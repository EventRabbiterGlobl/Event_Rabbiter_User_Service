package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileDto {

    private String name;
    private String phoneNumber;
    private String bio;
    private String description;
    private boolean profileVerification;
    private String listOfCategoryId;

}
