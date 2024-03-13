package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {


}
