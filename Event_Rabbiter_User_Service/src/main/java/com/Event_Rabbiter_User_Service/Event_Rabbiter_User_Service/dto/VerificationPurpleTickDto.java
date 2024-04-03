package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerificationPurpleTickDto {


    private String userVerificationId;
    private String UserName;


}
