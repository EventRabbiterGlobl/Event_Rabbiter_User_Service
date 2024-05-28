package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.controller;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.DateDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserListDatDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.CloudinaryService;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserProfileController {


    @Autowired
    private UserProfileService userProfileService;



    @Autowired
    private CloudinaryService cloudinaryService;




    @PostMapping("/saveProfile")
    public ResponseEntity<UserProfileDto> saveProfile(@RequestBody UserProfileDto userProfileDto){
        return ResponseEntity.ok(userProfileService.saveProfile(userProfileDto));
    }





    @GetMapping("/get/userProfile/{uuid}")
    public ResponseEntity<UserProfileDto> getProfile(
            @PathVariable String uuid){

        System.out.println(uuid);

        UserProfileDto userProfile = userProfileService.getProfile(uuid);
        System.out.println(userProfile.getDescription());
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
            @RequestBody UserProfileDto userProfileDto
            ){


        return ResponseEntity.ok(userProfileService.addEventPlace(userId,userProfileDto));
    }


    @GetMapping("/getAllUserDataForEventService")
    public ResponseEntity<List<UserProfile>> getAllDataForEventService() {
        List<UserProfile> userProfiles = userProfileService.sentDataEventService()
                .stream()
                .filter(UserProfile::isActivated).toList();
        return ResponseEntity.ok(userProfiles);
    }

    @GetMapping("/userData/for/chat/{recipientId}")
    public ResponseEntity<Optional<UserProfile>> gertUserForChat(
            @PathVariable String recipientId){
        Optional<UserProfile> user=userProfileService.getUser(recipientId);
        return ResponseEntity.ok(user);

    }


    @GetMapping("/getAllProfessionals")
    public  ResponseEntity<List<UserProfile>> getAllProfessionals(){
        return ResponseEntity.ok().body(userProfileService.getAllUser().stream().
                filter(UserProfile::isActivated).toList());
    }

    @PostMapping("/set/profile/photo")
    public UserProfile userProfilePhoto(@RequestParam("userId") String userId,
                                        @RequestParam("image") MultipartFile file){
        System.out.println(userId+"userId");
        return ResponseEntity.ok().body(userProfileService.setProfilePhoto(userId,file)).getBody();

    }

    @PostMapping("/get/user/list")
    public ResponseEntity<List<UserProfile>> getListOfUserProfile(@RequestBody UserListDatDto id) {
        List<UserProfile> userProfiles = userProfileService.listOfUser(id);
        System.out.println(userProfiles);
        return ResponseEntity.ok().body(userProfiles);
    }


    @PostMapping("/get/users/date")
    public ResponseEntity<List<UserProfile>> getUsersData(@RequestBody DateDto localDate) {
        System.out.println(localDate.getLocalDate());
        List<UserProfile> userProfiles = userProfileService.listOfUserInDate(localDate);
        return ResponseEntity.ok().body(userProfiles);
    }




}
