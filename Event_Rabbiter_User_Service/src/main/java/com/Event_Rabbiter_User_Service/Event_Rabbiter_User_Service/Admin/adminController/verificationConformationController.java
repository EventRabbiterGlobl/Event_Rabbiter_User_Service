package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminController;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ConformVerificationDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.ConformationVerification;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.VerificationPurpleTick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class verificationConformationController {



    @Autowired
    private ConformationVerification conformationVerification;

    @PostMapping("/conformationVerification")
    public ResponseEntity<Boolean> verification(@RequestBody ConformVerificationDto verification){
      return ResponseEntity.ok(conformationVerification.conformVerification(verification));
    }



    @GetMapping("/get/verification/profile")
    public ResponseEntity<List<UserProfileDto>> getProfileVerification(){
        List<UserProfileDto> verificationProfile=conformationVerification.findAllVerificationRequest();
        verificationProfile.stream()
                .map(UserProfileDto::getUsername)
                .forEach(username -> System.out.println("Username: " + username));
        return ResponseEntity.ok(verificationProfile);
    }


    @PutMapping("/verification/conformation/{userId}")
    public ResponseEntity<ConformVerificationDto> setVerification(@PathVariable("userId") String userId){

        return ResponseEntity.ok(conformationVerification.setVerification(userId));
    }














}
