package com.myhealth.microservices.health_services.dto;

public record DocterRequest(String id,String firstName, String lastName, String email, String specialization, int yearsOfExperience) {

}
