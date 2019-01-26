package com.example.appointment.service;

import com.example.appointment.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Optional<Appointment> findOneById(Long userId);

    Optional<Appointment> findOneByDoctorName(String name);

    List<Appointment> findAll();

    Appointment create(Appointment newUser);

    void deleteOneById(Long userId);

}
