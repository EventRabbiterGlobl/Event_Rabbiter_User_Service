package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class GatherGrove extends BaseEntity {
    private String gatherGroveName;
}
