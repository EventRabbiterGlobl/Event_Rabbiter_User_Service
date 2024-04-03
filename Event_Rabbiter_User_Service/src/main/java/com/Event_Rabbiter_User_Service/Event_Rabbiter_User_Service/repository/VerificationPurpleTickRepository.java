package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.VerificationPurpleTick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;






@Repository
public interface VerificationPurpleTickRepository extends JpaRepository<VerificationPurpleTick, UUID> {


}
