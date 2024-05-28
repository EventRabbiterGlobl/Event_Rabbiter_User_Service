package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class EventSeats extends BaseEntity {

    private Long seatNumber;

    @ManyToOne
    private UserProfile userProfile;


    @ManyToOne
    private EventSpaces eventSpaces;













}
