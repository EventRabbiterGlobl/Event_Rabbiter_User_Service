package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.serviceImp;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo.ListOfCategoryRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Exception.UserProfileNotFoundException;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.EventPlaceSeatDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.EventSeats;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.Team;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.EventSeatsRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.TeamRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.UserProfileRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.UserProfileService;
import com.sun.jdi.event.EventSet;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.auth.AuthStateCacheable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


@Slf4j
@Service
public class UserProfileIServiceImp implements UserProfileService {



    @Autowired
    private UserProfileRepository userProfileRepository;



    @Autowired
    private ModelMapper modelMapper;



    @Autowired
    private ListOfCategoryRepository listOfCategoryRepository;



    @Autowired
    private TeamRepository teamRepository;


    @Autowired
    private EventSeatsRepository eventSeatsRepository;


    @Override
    public UserProfileDto saveProfile(UserProfileDto profileDto) {
        UserProfile userProfile = modelMapper.map(profileDto, UserProfile.class);
        userProfile = userProfileRepository.save(userProfile);
        return modelMapper.map(userProfile, UserProfileDto.class);
    }

    @Override
    public UserProfileDto getProfile(String uuid) {
        Optional<UserProfile> getUserProfileId = userProfileRepository.findById(UUID.fromString(uuid));
        if (getUserProfileId.isPresent()) {
            UserProfile userProfile = getUserProfileId.get();
            return modelMapper.map(userProfile, UserProfileDto.class);
        } else {
            throw new UserProfileNotFoundException("UserProfile with ID " + uuid + " not found");
        }
    }




    @Override
    public UserProfileDto addProfile(String userId, UserProfileDto userProfileDto) {
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(UUID.fromString(userId));

        ListOfCategory listOfCategory = listOfCategoryRepository.findById(UUID.fromString(userProfileDto.getListOfCategoryId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

        UserProfile userProfile = getUserProfile(optionalUserProfile, "User profile with ID " + userId + " not found", userProfileDto, listOfCategory);
        userProfileRepository.save(userProfile);
        return modelMapper.map(userProfile, UserProfileDto.class);
    }

    @Override
    public UserProfileDto addUserTeam(String userId, UserProfileDto userProfileDto) {
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(UUID.fromString(userId));

        ListOfCategory category = listOfCategoryRepository.findById(UUID.fromString(userProfileDto.getListOfCategoryId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

        UserProfile userProfile = optionalUserProfile.orElseThrow(()
                -> new UserProfileNotFoundException("User profile with ID " + userId + " not found"));

        userProfile.setBio(userProfileDto.getBio());
        userProfile.setDescription(userProfileDto.getDescription());
        userProfile.setListOfCategory(category);
        userProfile = userProfileRepository.save(userProfile);

        List<String> names = userProfileDto.getNames();
        saveTeamNames(names, userProfile);
        return modelMapper.map(userProfile, UserProfileDto.class);
    }


    @Override
    public UserProfileDto addEventPlace(String userId, UserProfileDto userProfileDto) {
        Optional<UserProfile> optionalUserProfile =userProfileRepository.findById(UUID.fromString(userId));
        ListOfCategory category = listOfCategoryRepository.findById(UUID.fromString(userProfileDto.getListOfCategoryId()))
                .orElseThrow();

        UserProfile userProfile = getUserProfile(optionalUserProfile, "User Profile Not Fount", userProfileDto, category);
        userProfileRepository.save(userProfile);

        saveSeat(userProfileDto.getSeatNumber(),userProfile);

        return modelMapper.map(userProfile,UserProfileDto.class);
    }

    private UserProfile getUserProfile(Optional<UserProfile>
                                               optionalUserProfile,
                                       String User_Profile_Not_Fount,
                                       UserProfileDto userProfileDto,
                                       ListOfCategory category) {
        UserProfile userProfile = optionalUserProfile.orElseThrow(()
                -> new UserProfileNotFoundException(User_Profile_Not_Fount));

        userProfile.setBio(userProfileDto.getBio());
        userProfile.setDescription(userProfileDto.getDescription());
        userProfile.setListOfCategory(category);
        userProfile.setLocation(userProfileDto.getLocation());
        userProfile.setLocationLongitude(userProfileDto.getLocationLongitude());
        userProfile.setNameOfPlace(userProfileDto.getNameOfPlace());
        return userProfile;
    }


    private void saveTeamNames(List<String> names, UserProfile userProfile) {
        names.forEach(name->{
                    Team team= Team.builder()
                            .userProfile(userProfile)
                            .names(name)
                            .build();
                    teamRepository.save(team);
                });
    }

    private void  saveSeat(Long num,UserProfile userProfile){

        List<EventSeats> addSeat = new ArrayList<>();

        LongStream.rangeClosed(1,num)
                .forEach(i->{
                    EventSeats eventSeats = EventSeats.builder()
                            .seatNumber(i)
                            .userProfile(userProfile)
                            .build();
                    addSeat.add(eventSeats);
                });
        addSeat.sort(Comparator.comparing(EventSeats::getSeatNumber));
        eventSeatsRepository.saveAll(addSeat);

    }





}
