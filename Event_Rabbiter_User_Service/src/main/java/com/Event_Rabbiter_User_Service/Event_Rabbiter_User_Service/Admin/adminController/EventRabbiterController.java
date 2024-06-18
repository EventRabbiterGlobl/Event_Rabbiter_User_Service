package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminController;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.Image;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.ImageService;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.UserProfileDto;
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
public class EventRabbiterController {



    @Autowired
    private ImageService imageService;

    @PostMapping("/event-rabitter-image")
    public ResponseEntity<Image> addPlaceLocation(
            @RequestParam("image") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("number") int num
    ){
        return ResponseEntity.ok().body(imageService.saveImageInGuidance(file,name,num));
    }


    @GetMapping("/get-images-guidelines")
    public ResponseEntity<List<Image>> getAllImages(){
        return ResponseEntity.ok().body(imageService.getImages());
    }




}
