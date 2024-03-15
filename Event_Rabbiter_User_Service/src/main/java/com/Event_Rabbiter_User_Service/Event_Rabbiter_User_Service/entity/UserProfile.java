package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile extends BaseEntity {

    private String name;
    private String phoneNumber;
    private String bio;
    private String description;
    private boolean profileVerification;


    @OneToOne
    @JoinColumn(name = "userProfile_id")
    private ListOfCategory listOfCategory;

}
