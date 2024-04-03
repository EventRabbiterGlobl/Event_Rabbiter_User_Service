package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class EventSpaces extends BaseEntity {


    private double latitude;
    private double longitude;
    private String locationName;

    @ManyToOne
    private UserProfile userProfile;





}
