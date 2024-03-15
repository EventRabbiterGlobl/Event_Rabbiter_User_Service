package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminRepo;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminEntity.ListOfCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ListOfCategoryRepository extends JpaRepository<ListOfCategory, UUID> {
}
