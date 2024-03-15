package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminController;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.ListOfCategoryService;
import org.apache.hc.client5.http.auth.AuthStateCacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class ListOfCategoryController {



    @Autowired
    private ListOfCategoryService listOfCategoryService;


    @PostMapping("saveList")
    public ResponseEntity<ListOfCategoryDto> saveList(@RequestBody ListOfCategoryDto list){
        return  ResponseEntity.ok(listOfCategoryService.saveList(list));
    }



}
