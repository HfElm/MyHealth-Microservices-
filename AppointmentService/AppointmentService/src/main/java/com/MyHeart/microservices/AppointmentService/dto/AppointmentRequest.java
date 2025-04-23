package com.MyHeart.microservices.AppointmentService.dto;

import java.time.LocalDateTime;

public record AppointmentRequest( String patientId , String doctorId, LocalDateTime appointmentTime,String status) {

}
