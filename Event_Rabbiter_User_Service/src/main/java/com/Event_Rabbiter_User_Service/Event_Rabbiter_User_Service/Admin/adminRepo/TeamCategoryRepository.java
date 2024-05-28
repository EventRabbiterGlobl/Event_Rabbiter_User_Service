package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.TeamCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@Repository
public interface TeamCategoryRepository extends JpaRepository<TeamCategory, UUID> {
}
