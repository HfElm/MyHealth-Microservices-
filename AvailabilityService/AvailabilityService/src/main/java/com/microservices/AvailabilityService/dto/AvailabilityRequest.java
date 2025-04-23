package com.microservices.AvailabilityService.dto;

import com.microservices.AvailabilityService.model.AvailabilitySlot;

import java.time.LocalDateTime;

public record AvailabilityRequest(String doctorId, LocalDateTime startTime, LocalDateTime endTime) {
}
