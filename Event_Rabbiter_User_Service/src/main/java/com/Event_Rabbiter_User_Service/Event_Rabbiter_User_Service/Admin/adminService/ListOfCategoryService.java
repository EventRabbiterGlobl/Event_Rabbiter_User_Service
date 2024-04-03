package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;

import java.util.List;

public interface ListOfCategoryService {
    ListOfCategoryDto saveList(ListOfCategoryDto listSave);

    List<ListOfCategory> getAllListOfCategory();



}
