package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;

import java.util.UUID;

public interface UserProfileService {

    UserProfileDto saveProfile(UserProfileDto profileDto);

    UserProfileDto getProfile(String uuid);

    UserProfileDto addProfile(String userID, UserProfileDto userProfileDto);


    UserProfileDto addUserTeam(String userId, UserProfileDto userProfileDto);


    UserProfileDto addEventPlace(String userId, UserProfileDto userProfileDto);





}
