package com.myhealth.microservices.health_services;

import org.springframework.boot.SpringApplication;

public class TestHealthServicesApplication {

	public static void main(String[] args) {
		SpringApplication.from(HealthServicesApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
