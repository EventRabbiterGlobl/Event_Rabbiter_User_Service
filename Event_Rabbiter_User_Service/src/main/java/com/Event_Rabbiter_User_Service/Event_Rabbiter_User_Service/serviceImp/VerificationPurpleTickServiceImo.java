package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.serviceImp;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.VerificationPurpleTickDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.VerificationPurpleTick;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.VerificationPurpleTickRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.VerificationPurpleTickService;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.UserProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VerificationPurpleTickServiceImo implements VerificationPurpleTickService {


    @Autowired
    private UserProfileRepository userProfileRepository;


    @Autowired
    private VerificationPurpleTickRepository verificationPurpleTickRepository;



    @Override
    public VerificationPurpleTickDto verification(UUID verificationUserID) {

        UserProfile userProfileId = userProfileRepository.findById(verificationUserID)
                .orElseThrow(() -> new EntityNotFoundException("UserProfile not found with ID: " + verificationUserID));

        VerificationPurpleTick verificationPurpleTick = VerificationPurpleTick.builder()
                .userVerificationId(userProfileId)
                .build();
        verificationPurpleTickRepository.save(verificationPurpleTick);

        return VerificationPurpleTickDto.builder()
                .userVerificationId(String.valueOf(verificationPurpleTick.getUserVerificationId().getId()))
                .build();
    }

    private boolean isValidUUID(String uuidString) {
        try {
            UUID.fromString(uuidString);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }






}
