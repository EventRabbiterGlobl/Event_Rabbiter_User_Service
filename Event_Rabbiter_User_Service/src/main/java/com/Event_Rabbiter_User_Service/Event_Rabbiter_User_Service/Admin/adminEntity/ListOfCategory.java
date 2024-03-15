package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ListOfCategory extends BaseEntity {
    private String category;

}
