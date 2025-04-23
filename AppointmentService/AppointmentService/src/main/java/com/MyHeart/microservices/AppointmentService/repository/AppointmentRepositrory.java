package com.MyHeart.microservices.AppointmentService.repository;

import com.MyHeart.microservices.AppointmentService.model.appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepositrory extends JpaRepository<appointment, Long> {
    boolean existsByDoctorIdAndAppointmentTime(String doctorId, LocalDateTime appointmentTime);
}

