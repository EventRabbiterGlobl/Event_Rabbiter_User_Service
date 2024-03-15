package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.serviceImp;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo.ListOfCategoryRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.UserProfileRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.UserProfileService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.hc.client5.http.auth.AuthStateCacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class UserProfileIServiceImp implements UserProfileService {



    @Autowired
    private UserProfileRepository userProfileRepository;



    @Autowired
    private ListOfCategoryRepository listOfCategoryRepository;


    @Override
    public UserProfileDto saveProfile(UserProfileDto profileDto) {

        ListOfCategory listOfCategoryId = listOfCategoryRepository.findById(UUID.fromString(profileDto.getListOfCategoryId()))
                .orElseThrow(() -> new EntityNotFoundException("ListOfCategory not found with ID: " + profileDto.getListOfCategoryId()));


        UserProfile userProfile=UserProfile
              .builder()
              .name(profileDto.getName())
              .phoneNumber(profileDto.getPhoneNumber())
              .bio(profileDto.getBio())
              .listOfCategory(listOfCategoryId)
              .profileVerification(profileDto.isProfileVerification())
              .description(profileDto.getDescription())
              .build();

      userProfileRepository.save(userProfile);

        return UserProfileDto
                .builder()
                .name(userProfile.getName())
                .phoneNumber(userProfile.getPhoneNumber())
                .bio(userProfile.getBio())
                .listOfCategoryId(String.valueOf(userProfile.getListOfCategory()))
                .profileVerification(userProfile.isProfileVerification())
                .description(userProfile.getDescription())
                .build();
    }
}
