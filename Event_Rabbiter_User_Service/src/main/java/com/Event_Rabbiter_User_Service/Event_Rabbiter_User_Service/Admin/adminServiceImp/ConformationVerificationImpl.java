package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminServiceImp;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ConformVerificationDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.ConformationVerification;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.VerificationPurpleTick;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.UserProfileRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.VerificationPurpleTickRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ConformationVerificationImpl implements ConformationVerification {


    @Autowired
    private VerificationPurpleTickRepository verificationPurpleTickRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public List<UserProfileDto> findAllVerificationRequest() {
        List<VerificationPurpleTick> user = verificationPurpleTickRepository.findAll();
        List<UserProfileDto> userProfileDtos = user.stream()
                .map(verificationRequest -> {
                    Optional<UserProfile> userProfileOptional = userProfileRepository
                            .findById(verificationRequest.getUserVerificationId().getId());
                    if (userProfileOptional.isPresent()) {
                        UserProfile userProfile = userProfileOptional.get();
                        return mapToUserProfileDto(userProfile);
                    } else {
                        log.info("User profile not found for ID: " + verificationRequest.getId());
                        return new UserProfileDto();
                    }
                })
                .toList();
        userProfileDtos.forEach(userProfileDto -> System.out.println(userProfileDto.toString()));
        return userProfileDtos;
    }



    @Override
    public ConformVerificationDto setVerification(String userId) {
        UserProfile userProfileVerification = userProfileRepository.findById(UUID.fromString(userId))
                .orElse(null);
        if (userProfileVerification != null) {
            userProfileVerification.setProfileVerification(true);
            userProfileRepository.save(userProfileVerification);
            return modelMapper.map(userProfileVerification, ConformVerificationDto.class);
        }
        return null;
    }




    @Override
    public boolean conformVerification(ConformVerificationDto conformVerificationDto) {
        VerificationPurpleTick verificationUser=verificationPurpleTickRepository.
                findById(UUID.fromString(conformVerificationDto.getVerificationUserProfileId()))
                .orElseThrow(()-> new EntityNotFoundException("User not"));
        UserProfile userProfileId=verificationUser.getUserVerificationId();
        userProfileId.setProfileVerification(conformVerificationDto.isConformation());
        userProfileRepository.save(userProfileId);
        return true;
    }





    private UserProfileDto mapToUserProfileDto(UserProfile userProfile) {
        if (userProfile != null) {
            return modelMapper.map(userProfile, UserProfileDto.class);
        }
        return null;
    }




}
