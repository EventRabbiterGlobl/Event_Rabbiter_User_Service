package com.Event_Rabbiter_User_Service.Event_Rabbiter_User_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EnableFeignClients
public class EventRabbiterUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventRabbiterUserServiceApplication.class, args);
	}

}
