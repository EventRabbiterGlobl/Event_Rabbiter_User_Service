package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.GatherGrove;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.TeamCategory;

import java.util.List;

public interface TeamCategoryService {


    ListOfCategoryDto saveCategory (List<ListOfCategoryDto> categoryNames);

    List<TeamCategory> getAllTeamCategory();

}
