package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.serviceImp;

import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.dto.EventPlaceSeatDto;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.EventSeats;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.entity.UserProfile;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.EventSeatsRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.repository.UserProfileRepository;
import com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service.service.EventSeatsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;


@Service
public class EventSeatsServiceIml
        implements EventSeatsService {



    @Autowired
    private UserProfileRepository userProfileRepository;



    @Autowired
    private EventSeatsRepository eventSeatsRepository;

    @Override
    public String saveData(EventPlaceSeatDto data) {
        
        UserProfile userId=userProfileRepository.findById(UUID.fromString(data.getUserProfile()))
                .orElseThrow(()-> new EntityNotFoundException("user not fount"));

        int seatNumber= Math.toIntExact(data.getSeatNumber());



        List<EventSeats> seatList=new ArrayList<>();

        IntStream.rangeClosed(1,seatNumber)
                .forEach(i->{
                    EventSeats placeSeat= EventSeats
                            .builder()
                            .seatNumber((long) i)
                            .userProfile(userId)
                            .build();
                    seatList.add(placeSeat);
                });
        seatList.sort(Comparator.comparingLong(EventSeats::getSeatNumber));

        List<EventSeats> saveSeatData = eventSeatsRepository.saveAll(seatList);

        return "Seats saved successfully.";
    }



}
