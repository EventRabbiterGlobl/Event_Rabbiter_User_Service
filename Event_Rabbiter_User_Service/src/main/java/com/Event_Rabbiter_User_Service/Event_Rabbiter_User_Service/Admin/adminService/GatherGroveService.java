package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.GatherGrove;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;

import java.util.List;

public interface GatherGroveService {

    ListOfCategoryDto saveList(List<ListOfCategoryDto> list);
    List<GatherGrove> getAllIndividualCategory();

}
