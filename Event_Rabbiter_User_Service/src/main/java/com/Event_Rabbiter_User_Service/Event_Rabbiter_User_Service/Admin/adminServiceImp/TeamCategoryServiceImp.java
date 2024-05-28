package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminServiceImp;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.TeamCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo.TeamCategoryRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.TeamCategoryService;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeamCategoryServiceImp implements TeamCategoryService {

    @Autowired
    private TeamCategoryRepository teamCategoryRepository;

    @Override
    public ListOfCategoryDto saveCategory(List<ListOfCategoryDto> categoryNames) {
        List<TeamCategory> teamCategories=categoryNames.stream()
                .map(categoryName->
                        TeamCategory.builder()
                                .teamCategoryName(categoryName.getCategory())
                                .build()
                ).toList();
        List<TeamCategory> listOfSaveData=teamCategoryRepository.saveAll(teamCategories);
        List<String> listData=listOfSaveData.stream()
                .map(TeamCategory::getTeamCategoryName)
                .toList();
        return new ListOfCategoryDto(listData.toString());
    }

    @Override
    public List<TeamCategory> getAllTeamCategory() {
        return teamCategoryRepository.findAll();
    }
}
