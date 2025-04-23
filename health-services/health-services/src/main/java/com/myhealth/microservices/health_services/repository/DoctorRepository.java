package com.myhealth.microservices.health_services.repository;

import com.myhealth.microservices.health_services.model.doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<doctor, String > {
}
