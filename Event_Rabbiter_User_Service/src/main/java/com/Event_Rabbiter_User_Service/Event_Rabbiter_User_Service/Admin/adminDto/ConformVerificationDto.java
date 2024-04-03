package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.Admin.adminDto;


import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConformVerificationDto {


    private String  verificationUserProfileId;
    private boolean conformation;

}
