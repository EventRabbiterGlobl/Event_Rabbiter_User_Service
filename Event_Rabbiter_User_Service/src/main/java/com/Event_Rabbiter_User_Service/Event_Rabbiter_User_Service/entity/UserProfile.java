package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity;


import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile extends BaseEntity{

    private String name;
    private String phoneNumber;
    private String bio;
    private String description;
    private boolean profileVerification;

}
