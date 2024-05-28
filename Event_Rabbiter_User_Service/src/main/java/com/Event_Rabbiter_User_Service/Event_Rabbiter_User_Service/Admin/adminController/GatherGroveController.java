package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminController;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.GatherGrove;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.GatherGroveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class GatherGroveController {



    @Autowired
    private GatherGroveService gatherGroveService;


    @PostMapping("/save/gatherGrove")
    public ResponseEntity<ListOfCategoryDto> saveList(@RequestBody List<ListOfCategoryDto> list){
        return  ResponseEntity.ok(gatherGroveService.saveList(list));
    }


    @GetMapping("/get/gatherGrove")
    public ResponseEntity<List<GatherGrove>> getAllGather(){
        List<GatherGrove> gatherGroves=gatherGroveService.getAllIndividualCategory();
        return ResponseEntity.ok().body(gatherGroves);
    }




}
