package com.myhealth.microservices.health_services.service;

import com.myhealth.microservices.health_services.dto.DocterRequest;
import com.myhealth.microservices.health_services.model.doctor;
import com.myhealth.microservices.health_services.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorService {
    private final DoctorRepository doctorRepository;
    public doctor createDoctor (DocterRequest doctorRequest){
        doctor newdoctor = doctor.builder()
                .firstName(doctorRequest.firstName())
                .lastName(doctorRequest.lastName())
                .email(doctorRequest.email())
                .specialization(doctorRequest.specialization())
                .yearsOfExperience(doctorRequest.yearsOfExperience())
                .build();
        doctorRepository.save(newdoctor);
        log.info("doctor created successfully");
        return newdoctor;
    };
    public List<doctor> getAllDoctors(){
          return doctorRepository.findAll();
    }
}
