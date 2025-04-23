package com.MyHeart.microservices.AppointmentService;

import org.springframework.boot.SpringApplication;

public class TestAppointmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(AppointmentServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
