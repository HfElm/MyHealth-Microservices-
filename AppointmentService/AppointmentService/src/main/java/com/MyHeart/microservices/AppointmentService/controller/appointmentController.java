package com.MyHeart.microservices.AppointmentService.controller;


import com.MyHeart.microservices.AppointmentService.Service.AppointmentService;
import com.MyHeart.microservices.AppointmentService.dto.AppointmentRequest;
import com.MyHeart.microservices.AppointmentService.repository.AppointmentRepositrory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@Slf4j
@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
public class appointmentController {
    private final AppointmentService appointmentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String appointment(@RequestBody AppointmentRequest appointmentRequest) {
        appointmentService.placeAppointment(appointmentRequest);
        return "appointment Placed successfuly";
    }
    private final AppointmentRepositrory appointmentRepository;
    @GetMapping("/check")
    public boolean isSlotTaken(@RequestParam String doctorId, @RequestParam String time) {
        log.info("Checking if slot is taken for doctor ID: {} at time: {}", doctorId, time);

        LocalDateTime dateTime = LocalDateTime.parse(time);
        boolean exists = appointmentRepository.existsByDoctorIdAndAppointmentTime(doctorId, dateTime);

        log.info("Slot taken: {}", exists);
        return exists;
    }
    /*@GetMapping("/ping")
    public String ping() {
        return "pong from AppointmentService";
    } */

}

