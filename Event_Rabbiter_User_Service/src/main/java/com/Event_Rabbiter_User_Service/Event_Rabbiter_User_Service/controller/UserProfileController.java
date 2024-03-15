package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.controller;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserProfileController {


    @Autowired
    private UserProfileService userProfileService;




    @PostMapping("/saveProfile")
    public ResponseEntity<UserProfileDto> saveProfile(@RequestBody UserProfileDto userProfileDto){
        return ResponseEntity.ok(userProfileService.saveProfile(userProfileDto));
    }




}
