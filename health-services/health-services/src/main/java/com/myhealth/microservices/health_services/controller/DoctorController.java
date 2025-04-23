package com.myhealth.microservices.health_services.controller;

import com.myhealth.microservices.health_services.model.doctor;
import lombok.RequiredArgsConstructor;
import com.myhealth.microservices.health_services.dto.DocterRequest;
import org.springframework.http.HttpStatus;
import com.myhealth.microservices.health_services.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
public class DoctorController {
     private final  DoctorService doctorService;
     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public doctor creatDoctor(@RequestBody DocterRequest doctorRequest){
          return doctorService.createDoctor(doctorRequest);
     }
     @GetMapping
     @ResponseStatus(HttpStatus.OK)
     public List<doctor> getAllDoctors(){
         return doctorService.getAllDoctors();
     }
}
