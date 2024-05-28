package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminServiceImp;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto.ListOfCategoryDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.GatherGrove;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo.GatherGroveRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminService.GatherGroveService;
import com.netflix.discovery.converters.Auto;
import org.apache.hc.client5.http.auth.AuthStateCacheable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatherGroveServiceImp implements GatherGroveService {

    @Autowired
    private GatherGroveRepository gatherGroveRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ListOfCategoryDto saveList(List<ListOfCategoryDto> list) {
    List<GatherGrove> gatherGrovesList=list.stream()
            .map(listOfName->
                    GatherGrove.builder()
                            .gatherGroveName(listOfName.getCategory())
                            .build()
                    ).toList();
    List<GatherGrove> gatherGrovesListSave=gatherGroveRepository.saveAll(gatherGrovesList);
    List<String> listOfName=gatherGrovesListSave.stream()
            .map(GatherGrove::getGatherGroveName)
            .toList();
    return new ListOfCategoryDto(listOfName.toString());
    }

    @Override
    public List<GatherGrove> getAllIndividualCategory() {
        return gatherGroveRepository.findAll();
    }
}
