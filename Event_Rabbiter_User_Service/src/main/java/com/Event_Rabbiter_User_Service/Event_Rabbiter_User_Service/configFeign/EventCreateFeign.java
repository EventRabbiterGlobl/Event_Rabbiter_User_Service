package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.configFeign;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.DateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name ="EVENT-SERVICE")
public interface EventCreateFeign {

    @PostMapping("/getUserSpecificDate")
    ResponseEntity<List<String>> getUserInSpecificData(@RequestBody DateDto dateDto);


}
