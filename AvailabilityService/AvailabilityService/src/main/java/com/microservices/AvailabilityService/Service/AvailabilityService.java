package com.microservices.AvailabilityService.Service;


import com.microservices.AvailabilityService.Repository.AvailabilitySlotRepository;
import com.microservices.AvailabilityService.dto.AvailabilityRequest;
import com.microservices.AvailabilityService.model.AvailabilitySlot;
import org.springframework.web.reactive.function.client.WebClient;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AvailabilityService {
    private final AvailabilitySlotRepository AvailabilitySlotRepository;
    public void placeAvailability(AvailabilityRequest availabilityRequest ){
        //map
        AvailabilitySlot availabilitySlot = new AvailabilitySlot();
        availabilitySlot.setId(UUID.randomUUID().toString());
        availabilitySlot.setDoctorId(availabilityRequest.doctorId());
        availabilitySlot.setEndTime(availabilityRequest.endTime());
        availabilitySlot.setStartTime(availabilityRequest.startTime());
        //save
        AvailabilitySlotRepository.save(availabilitySlot);
    }

    private final WebClient.Builder webClientBuilder;

    public List<LocalDateTime> getAvailableSlots(String doctorId) {
        log.info("Fetching available slots for doctor ID: {}", doctorId);

        List<AvailabilitySlot> availabilities = AvailabilitySlotRepository.findByDoctorId(doctorId);
        List<LocalDateTime> availableSlots = new ArrayList<>();

        for (AvailabilitySlot a : availabilities) {
            log.info("boucle for ");

            LocalDateTime current = a.getStartTime();
            log.info("Checking slots from {} to {}", a.getStartTime(), a.getEndTime());

            while (current.isBefore(a.getEndTime())) {
                log.info("Checking if time {} is already taken...", current);

                boolean isTaken = webClientBuilder.build()
                        .get()
                        .uri("http://localhost:8081/api/appointment/check?doctorId=" + doctorId + "&time=" + current)
                        .retrieve()
                        .bodyToMono(Boolean.class)
                        .block();

                if (!isTaken) {
                    log.info("Slot {} is available", current);
                    availableSlots.add(current);
                } else {
                    log.info("Slot {} is already taken", current);
                }

                current = current.plusMinutes(30);
            }
        }

        log.info("Found {} available slots for doctor {}", availableSlots.size(), doctorId);
        return availableSlots;
    }



}
