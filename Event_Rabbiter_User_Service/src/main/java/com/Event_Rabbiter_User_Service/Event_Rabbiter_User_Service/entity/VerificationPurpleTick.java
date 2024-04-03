package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.baseEntity.BaseEntity;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class VerificationPurpleTick  extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "verification_id")
    private UserProfile userVerificationId;

}
