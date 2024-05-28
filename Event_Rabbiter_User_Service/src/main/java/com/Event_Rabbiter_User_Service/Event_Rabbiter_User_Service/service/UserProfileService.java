package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.DateDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserListDatDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserProfileService {

    UserProfileDto saveProfile(UserProfileDto profileDto);



    UserProfileDto getProfile(String uuid);

    UserProfileDto addProfile(String userID, UserProfileDto userProfileDto);


    UserProfileDto addUserTeam(String userId, UserProfileDto userProfileDto);


    UserProfileDto addEventPlace(String userId, UserProfileDto userProfileDto);

    List<UserProfile> sentDataEventService();

    Optional<UserProfile> getUser(String userId);

    List<UserProfile> getAllUser();


    UserProfile setProfilePhoto(String userId, MultipartFile file);

    List<UserProfile> listOfUser(UserListDatDto id);

    List<UserProfile> listOfUserInDate(DateDto localDateTime);







}
