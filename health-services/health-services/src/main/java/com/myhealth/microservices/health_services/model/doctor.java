package com.myhealth.microservices.health_services.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(value="doctor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class doctor {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String specialization;
    private int yearsOfExperience;
}
