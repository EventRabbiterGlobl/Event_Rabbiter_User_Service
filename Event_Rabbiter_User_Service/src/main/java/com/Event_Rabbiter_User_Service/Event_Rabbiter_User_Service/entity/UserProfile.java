package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;
import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile  {

    @Id
    private UUID id;
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
    private double location;
    private double locationLongitude;
    private String nameOfPlace;


    @ManyToOne
    private ListOfCategory listOfCategory;


}
