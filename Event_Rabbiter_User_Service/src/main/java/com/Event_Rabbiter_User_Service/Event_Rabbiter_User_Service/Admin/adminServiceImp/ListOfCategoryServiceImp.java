package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminServiceImp;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo.ListOfCategoryRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.ListOfCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ListOfCategoryServiceImp implements ListOfCategoryService {
    @Autowired
    private ListOfCategoryRepository listOfCategoryRepository;


    @Override
    public ListOfCategoryDto saveList(ListOfCategoryDto listSave) {

        ListOfCategory listOfCategory=ListOfCategory
                .builder()
                .category(listSave.getCategory())
                .build();
        listOfCategoryRepository.save(listOfCategory);
        return ListOfCategoryDto
                .builder()
                .category(listOfCategory.getCategory())
                .build();
    }

    @Override
    public List<ListOfCategory> getAllListOfCategory() {
        return listOfCategoryRepository.findAll();
    }


}
