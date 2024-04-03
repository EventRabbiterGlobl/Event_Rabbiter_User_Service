package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ConformVerificationDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.VerificationPurpleTick;

import java.util.List;

public interface ConformationVerification {



    List<UserProfileDto> findAllVerificationRequest();

    ConformVerificationDto setVerification(String userId);


    boolean conformVerification(ConformVerificationDto conformVerificationDto);



}
