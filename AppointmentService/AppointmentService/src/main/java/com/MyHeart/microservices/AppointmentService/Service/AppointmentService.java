package com.MyHeart.microservices.AppointmentService.Service;

import com.MyHeart.microservices.AppointmentService.dto.AppointmentRequest;
import com.MyHeart.microservices.AppointmentService.model.appointment;
import com.MyHeart.microservices.AppointmentService.repository.AppointmentRepositrory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepositrory appointmentRepositrory;

    public void placeAppointment(AppointmentRequest appointmentRequest) {
        //map AppointmentRequest
        appointment newappointment = new appointment();
        newappointment.setId(UUID.randomUUID().toString());
        newappointment.setPatientId(appointmentRequest.patientId());
        newappointment.setDoctorId(appointmentRequest.doctorId());
        newappointment.setAppointmentTime(appointmentRequest.appointmentTime());
        newappointment.setStatus(appointmentRequest.status());
        //save appointment to appointment repository
        appointmentRepositrory.save(newappointment);
    }
}
