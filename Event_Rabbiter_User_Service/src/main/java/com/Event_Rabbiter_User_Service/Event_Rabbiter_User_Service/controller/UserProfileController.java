package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.controller;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.UserProfileRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserProfileController {


    @Autowired
    private UserProfileService userProfileService;




    @PostMapping("/saveProfile")
    public ResponseEntity<UserProfileDto> saveProfile(@RequestBody UserProfileDto userProfileDto){
        return ResponseEntity.ok(userProfileService.saveProfile(userProfileDto));
    }

    @GetMapping("/get/userProfile/{uuid}")
    public ResponseEntity<UserProfileDto> getProfile(@PathVariable String uuid){
        UserProfileDto userProfile = userProfileService.getProfile(uuid);
        return ResponseEntity.ok(userProfile);
    }


    @PostMapping("/addUserProfile/{userId}")
    public ResponseEntity<UserProfileDto>  addMoreProfile(
            @PathVariable("userId") String userId,
            @RequestBody UserProfileDto userProfileDto){
        return  ResponseEntity.ok(userProfileService.addProfile(userId,userProfileDto));
    }


    @PostMapping("/userProfile/addTeamMember/{userId}")
    public ResponseEntity<UserProfileDto> addTeam(
            @PathVariable("userId") String userId,
            @RequestBody UserProfileDto userProfileDto){
        return ResponseEntity.ok(userProfileService.addUserTeam(userId,userProfileDto));
    }


    @PostMapping("/save/place/seat/{userId}")
    public ResponseEntity<UserProfileDto> addPlaceLocation(
            @PathVariable("userId") String userId,
            @RequestBody UserProfileDto userProfileDto){

        log.info(userProfileDto.getBio(),userProfileDto.getNameOfPlace());

        return ResponseEntity.ok(userProfileService.addEventPlace(userId,userProfileDto));

    }



}
