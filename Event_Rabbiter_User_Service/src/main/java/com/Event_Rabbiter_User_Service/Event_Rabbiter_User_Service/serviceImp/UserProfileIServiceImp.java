package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.serviceImp;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.GatherGrove;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.IndividualCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.TeamCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo.GatherGroveRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo.IndividualCategoryRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo.ListOfCategoryRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo.TeamCategoryRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.GatherGroveService;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.IndividualCategoryService;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.TeamCategoryService;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Exception.UserProfileNotFoundException;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.configFeign.EventCreateFeign;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.DateDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserListDatDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.EventSeats;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.Team;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.EventSeatsRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.TeamRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.UserProfileRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.CloudinaryService;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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


    @Autowired
    private IndividualCategoryRepository individualCategoryRepository;


    @Autowired
    private GatherGroveRepository gatherGroveRepository;


    @Autowired
    private TeamCategoryRepository teamCategoryRepository;


    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private EventCreateFeign eventCreateFeign;



    @Override
    public UserProfileDto saveProfile(UserProfileDto profileDto) {
        System.out.println(profileDto.getEmail()+"00000000000000000000000");
        UserProfile userProfile = modelMapper.map(profileDto, UserProfile.class);
        userProfile = userProfileRepository.save(userProfile);
        return modelMapper.map(userProfile, UserProfileDto.class);
    }



    @Override
    public UserProfileDto getProfile(String uuid) {
        UUID data= UUID.fromString(uuid);
        Optional<UserProfile> getUserProfileId = userProfileRepository.findById(data);
        if (getUserProfileId.isPresent()) {
            UserProfile userProfile = getUserProfileId.get();
            System.out.println(getUserProfileId.get());
            return modelMapper.map(userProfile, UserProfileDto.class);
        } else {
            throw new UserProfileNotFoundException("UserProfile with ID " + uuid + " not found");
        }
    }




    public UserProfileDto addProfile(String userId, UserProfileDto userProfileDto) {

       Optional <UserProfile> userProfileData = userProfileRepository.findById(UUID.fromString(userId));
        IndividualCategory individualCategory = individualCategoryRepository.findById(UUID.fromString(userProfileDto.getListOfCategoryId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

        if (userProfileData.isPresent()) {
            UserProfile userProfile = userProfileData.get();
            userProfile.setBio(userProfileDto.getBio());
            userProfile.setDescription(userProfileDto.getDescription());
            userProfile.setIndividualCategory(individualCategory);
            userProfile.setNameOfPlace(userProfileDto.getNameOfPlace());
            userProfile.setActivated(true);
            UserProfile savedUserProfile = userProfileRepository.save(userProfile);
            return modelMapper.map(savedUserProfile, UserProfileDto.class);
        }else {
            throw new UserProfileNotFoundException("User profile not found");

        }
    }



    @Override
    public UserProfileDto addUserTeam(String userId, UserProfileDto userProfileDto) {
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(UUID.fromString(userId));

        TeamCategory teamCategory = teamCategoryRepository.findById(UUID.fromString(userProfileDto.getListOfCategoryId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

        UserProfile userProfile = optionalUserProfile.orElseThrow(()
                -> new UserProfileNotFoundException("User profile with ID " + userId + " not found"));

        userProfile.setBio(userProfileDto.getBio());
        userProfile.setDescription(userProfileDto.getDescription());
        userProfile.setTeamCategory(teamCategory);
        userProfile.setActivated(true);
        userProfile = userProfileRepository.save(userProfile);
        List<String> names = userProfileDto.getNames();
        saveTeamNames(names, userProfile);
        return modelMapper.map(userProfile, UserProfileDto.class);
    }






    @Override
    public UserProfileDto addEventPlace(String userId, UserProfileDto userProfileDto) {
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(UUID.fromString(userId));

        GatherGrove gatherGrove = gatherGroveRepository.findById(UUID.fromString(userProfileDto.getListOfCategoryId()))
                .orElseThrow(() -> new IllegalArgumentException("GatherGrove not found"));

        if (optionalUserProfile.isPresent()) {
            UserProfile userProfile = getUserProfile(userProfileDto, optionalUserProfile, gatherGrove);
            UserProfile saveData=userProfileRepository.save(userProfile);
            saveSeat(userProfileDto.getSeatNumber(),userProfile);
            return modelMapper.map(saveData, UserProfileDto.class);
        } else {
            throw new UserProfileNotFoundException("User profile not found");
        }
    }



    @Override
    public List<UserProfile> sentDataEventService() {
        return userProfileRepository.findAll();
    }







    @Override
    public Optional<UserProfile> getUser(String userId) {
        try {
            UUID uuid = UUID.fromString(userId);
            return userProfileRepository.findById(uuid);
        } catch (IllegalArgumentException | NullPointerException e) {

            System.err.println("Invalid userId: " + userId);
            return Optional.empty();
        }
    }








    @Override
    public List<UserProfile> getAllUser() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile setProfilePhoto(String userId, MultipartFile file) {
        Optional<UserProfile> userProfileId=userProfileRepository.findById(UUID.fromString(userId));

        if (userProfileId.isPresent()){


            String folder = "profile_pictures";
            Map data = cloudinaryService.upload(file,folder);

            String imageUrl = (String) data.get("secure_url");
            String publicId = (String) data.get("public_id");

            UserProfile userProfile=userProfileId.get();
            userProfile.setImageUrl(imageUrl);
            userProfile.setImagePublicId(publicId);
            return userProfileRepository.save(userProfile);
        }
        return null;
    }

    @Override
    public List<UserProfile> listOfUser(UserListDatDto id) {
        List<UUID> userIds=id.getId().stream()
                .map(UUID::fromString)
                .toList();
        return userProfileRepository.findAllById(userIds);
    }



    @Override
    public List<UserProfile> listOfUserInDate(DateDto localDateTime) {


        ResponseEntity<List<String>> responseEntity = eventCreateFeign.getUserInSpecificData(localDateTime);
        List<String> listOfUserId = Optional.ofNullable(responseEntity.getBody()).orElse(Collections.emptyList());
        List<UserProfile> allUserProfiles = userProfileRepository.findAll();


        return allUserProfiles.stream()
                .filter(userProfile -> !listOfUserId.contains(userProfile.getId().toString()))
                .collect(Collectors.toList());
    }



    private UserProfile getUserProfile(UserProfileDto userProfileDto, Optional<UserProfile> optionalUserProfile, GatherGrove gatherGrove) {
        UserProfile userProfile= optionalUserProfile.get();
        userProfile.setBio(userProfileDto.getBio());
        userProfile.setDescription(userProfileDto.getDescription());
        userProfile.setGatherGrove(gatherGrove);
        userProfile.setLocation(userProfileDto.getLocation());
        userProfile.setLocationLongitude(userProfileDto.getLocationLongitude());
        userProfile.setNameOfPlace(userProfileDto.getNameOfPlace());
        userProfile.setActivated(true);
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
