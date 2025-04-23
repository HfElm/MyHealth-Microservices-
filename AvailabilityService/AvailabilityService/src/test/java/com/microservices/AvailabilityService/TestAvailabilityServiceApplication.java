package com.microservices.AvailabilityService;

import org.springframework.boot.SpringApplication;

public class TestAvailabilityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(AvailabilityServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
