package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerificationRequest {

    private boolean profileVerification;
    private String listOfCategoryId;

}
