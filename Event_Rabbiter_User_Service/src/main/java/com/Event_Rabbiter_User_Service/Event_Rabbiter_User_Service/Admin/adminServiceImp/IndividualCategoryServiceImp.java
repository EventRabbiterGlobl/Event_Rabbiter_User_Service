package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminServiceImp;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.IndividualCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo.IndividualCategoryRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.IndividualCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualCategoryServiceImp implements IndividualCategoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IndividualCategoryRepository individualCategoryRepository;




    public ListOfCategoryDto saveList(List<ListOfCategoryDto> categoryNames) {
        List<IndividualCategory> individualCategories=categoryNames.stream()
                .map(categoryName->
                        IndividualCategory.builder()
                                .individualCategoryName(categoryName.getCategory())
                                .build()
                        ).toList();




        List<IndividualCategory> listOfSave=individualCategoryRepository.saveAll(individualCategories);
        List<String> listOfCategoriesList=listOfSave.stream()
                .map(IndividualCategory::getIndividualCategoryName)
                .toList();
        return new ListOfCategoryDto(listOfCategoriesList.toString());
    }
    @Override
    public List<IndividualCategory> getAllIndividualCategory() {
        return individualCategoryRepository.findAll();
    }

}
