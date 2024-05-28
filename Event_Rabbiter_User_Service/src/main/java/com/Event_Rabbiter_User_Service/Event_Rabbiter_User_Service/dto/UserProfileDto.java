package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;
import lombok.*;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileDto {

    private UUID   id;
    private String firstName;
    private String secondName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String otp;
    private String bio;
    private String description;
    private boolean profileVerification;
    private String listOfCategoryId;
    private String imageUrl;
    private String imagePublicId;
    private boolean activated ;
    private boolean deleted ;



    private double location;
    private double locationLongitude;
    private String nameOfPlace;
    private Long seatNumber;




    private List<String> names;


}
