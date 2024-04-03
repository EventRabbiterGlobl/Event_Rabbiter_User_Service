package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;
import lombok.*;

import java.awt.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventPlaceSeatDto {

    private String userProfile;
    private Long   seatNumber;
    private Point  location;

}
