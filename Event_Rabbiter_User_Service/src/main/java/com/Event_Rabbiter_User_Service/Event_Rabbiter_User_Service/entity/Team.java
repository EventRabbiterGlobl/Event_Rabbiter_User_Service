package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Team extends BaseEntity {

    private String names;

    @ManyToOne
    private UserProfile userProfile;



}
