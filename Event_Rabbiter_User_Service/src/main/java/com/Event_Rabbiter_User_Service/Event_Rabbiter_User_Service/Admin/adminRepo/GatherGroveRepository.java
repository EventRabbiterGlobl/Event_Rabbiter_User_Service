package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.GatherGrove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface GatherGroveRepository extends JpaRepository<GatherGrove, UUID> {



}
