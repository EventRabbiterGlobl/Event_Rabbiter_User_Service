package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.EventSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface EventSeatsRepository
        extends JpaRepository<EventSeats, UUID> {
}
