package com.microservices.AvailabilityService.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_availability")
public class AvailabilitySlot {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;
    @Column(name = "doctor_id", nullable = false)
    private String doctorId;
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;
    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;
}
