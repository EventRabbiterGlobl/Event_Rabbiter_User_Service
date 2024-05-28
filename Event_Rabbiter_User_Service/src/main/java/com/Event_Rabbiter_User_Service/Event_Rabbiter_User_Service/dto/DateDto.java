package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Getter
@Setter
public class DateDto {

    private LocalDate localDate;
}
