package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.controller;


import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.EventPlaceSeatDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.EventSeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class EventSeatsController {


    @Autowired
    private EventSeatsService eventSeatsService;


    @PostMapping("/seatData")
    public ResponseEntity<String> saveSeatData(@RequestBody EventPlaceSeatDto data) {
        return ResponseEntity.ok(eventSeatsService.saveData(data));
    }








}
