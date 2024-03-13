package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private boolean activated ;
    private boolean deleted ;

}
