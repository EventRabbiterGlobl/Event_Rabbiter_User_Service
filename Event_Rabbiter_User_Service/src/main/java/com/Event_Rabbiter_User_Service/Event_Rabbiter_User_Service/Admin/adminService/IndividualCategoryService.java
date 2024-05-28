package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.IndividualCategory;

import java.util.List;

public interface IndividualCategoryService {
    ListOfCategoryDto saveList(List<ListOfCategoryDto> categoryNames);
    List<IndividualCategory> getAllIndividualCategory();



}
