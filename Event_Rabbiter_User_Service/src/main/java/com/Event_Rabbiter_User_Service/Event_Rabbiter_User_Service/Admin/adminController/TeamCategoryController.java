package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminController;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.TeamCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.TeamCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class TeamCategoryController {

    @Autowired
    private TeamCategoryService teamCategoryService;


    @PostMapping("/save/teamCategory")
    public ResponseEntity<ListOfCategoryDto> saveList(@RequestBody List<ListOfCategoryDto> categoryNames ){
        return  ResponseEntity.ok(teamCategoryService.saveCategory(categoryNames));
    }


    @GetMapping("/get/teamCategory")
    public ResponseEntity<List<TeamCategory>> getAllTeamCategory(){
        return  ResponseEntity.ok().body(teamCategoryService.getAllTeamCategory());
    }



}
