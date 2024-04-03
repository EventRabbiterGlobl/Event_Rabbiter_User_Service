package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.controller;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.VerificationPurpleTickDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.VerificationPurpleTickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/user")
public class VerificationController {


    @Autowired
    private VerificationPurpleTickService verificationPurpleTickService;



    @PostMapping("/verification")
    public ResponseEntity<VerificationPurpleTickDto> verification(@RequestBody VerificationPurpleTickDto verificationDto) {
        UUID verificationId = UUID.fromString(verificationDto.getUserVerificationId());
        return ResponseEntity.ok(verificationPurpleTickService.verification(verificationId));
    }



}
