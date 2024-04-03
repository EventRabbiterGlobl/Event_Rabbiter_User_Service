package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.VerificationPurpleTickDto;

import java.util.UUID;


public interface VerificationPurpleTickService {

    VerificationPurpleTickDto verification(UUID verificationUserID);
}
