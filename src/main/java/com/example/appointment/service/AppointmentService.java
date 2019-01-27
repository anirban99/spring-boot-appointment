package com.example.appointment.service;

import com.example.appointment.model.Appointment;
import com.example.appointment.model.AppointmentStatus;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Optional<Appointment> findById(Long appointmentId);

    List<Appointment> findAll();

    List<Appointment> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate);

    Appointment create(Appointment appointment);

    Appointment update(Long appointmentId, Appointment appointment);

//    void updateStatus(Long appointmentId, AppointmentStatus status);

//    void updateStatus(Long appointmentId, Appointment appointment) throws ResourceNotFoundException;

    void deleteById(Long appointmentId);

}
