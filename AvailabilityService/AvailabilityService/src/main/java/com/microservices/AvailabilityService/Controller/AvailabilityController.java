package com.microservices.AvailabilityService.Controller;



import com.microservices.AvailabilityService.Service.AvailabilityService;
import com.microservices.AvailabilityService.dto.AvailabilityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@RequestMapping("/api/Availability")
@RequiredArgsConstructor
public class AvailabilityController {
     private final AvailabilityService availabilityService ;
     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public String placeAvailability(@RequestBody AvailabilityRequest availabilityRequest) {
         availabilityService.placeAvailability(availabilityRequest);
         return "availability saved";
     }
    @GetMapping("/available-slots/{doctorId}")
    public List<LocalDateTime> getAvailableSlots(@PathVariable String doctorId) {
        return availabilityService.getAvailableSlots(doctorId);
    }

    private final WebClient.Builder webClientBuilder;
/*
    @GetMapping("/check-appointment")
    public String checkAppointmentService() {
        String response = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/appointment/ping")
                .retrieve()
                .bodyToMono(String.class)
                .block(); // bloquant juste pour test

        return "Response from AppointmentService: " + response;
    }*/


}
