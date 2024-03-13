package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;

public interface UserProfileService {

    UserProfileDto saveProfile(UserProfileDto profileDto);
}
