package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminController;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.IndividualCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.IndividualCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class IndividualCategoryController {



    @Autowired
    private IndividualCategoryService individualCategoryService;


    @PostMapping("/save/individualCategory")
    public ResponseEntity<ListOfCategoryDto> saveList(@RequestBody List<ListOfCategoryDto> categories){
        return  ResponseEntity.ok(individualCategoryService.saveList(categories));
    }

    @GetMapping("/get/individualCategory")
    public ResponseEntity<List<IndividualCategory>> gerAllListOfIndividualCategory() {
        List<IndividualCategory> individualCategories = individualCategoryService.getAllIndividualCategory();
        return ResponseEntity.ok().body(individualCategories);
    }

}
