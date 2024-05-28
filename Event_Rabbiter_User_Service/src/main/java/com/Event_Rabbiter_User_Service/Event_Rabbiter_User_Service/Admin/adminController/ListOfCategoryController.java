package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminController;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.ListOfCategoryService;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.CloudinaryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/user")
public class ListOfCategoryController {



    @Autowired
    private ListOfCategoryService listOfCategoryService;


    @PostMapping("saveList")
    public ResponseEntity<ListOfCategoryDto> saveList(@RequestBody ListOfCategoryDto list){
        return  ResponseEntity.ok(listOfCategoryService.saveList(list));
    }



    @GetMapping("/getAllList")
    public ResponseEntity<List<ListOfCategory>> getAllListOfCategory() {
        List<ListOfCategory> categories = listOfCategoryService.getAllListOfCategory();
        return ResponseEntity.ok(categories);
    }



    @Autowired
    private  CloudinaryService cloudinaryService;

    @PostMapping("/images")
    public ResponseEntity<Map> uploadImage(@RequestParam("image")MultipartFile file){
        String folder = "Certificates";
        Map data = cloudinaryService.upload(file,folder);
        return ResponseEntity.ok(data);
    }


    @PostMapping("/test/save/place/seat")
    public Map addPlaceLocation(
            @RequestParam("image") MultipartFile file,
            @RequestParam("registerEventPlaceData") String userProfileDtoJson
    ){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            UserProfileDto userProfileDto = objectMapper.readValue(userProfileDtoJson, UserProfileDto.class);


            String folder = "Certificates";
            Map data = cloudinaryService.upload(file,folder);


            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


















}
