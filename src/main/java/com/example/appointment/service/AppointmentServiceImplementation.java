package com.example.appointment.service;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("appointmentService")
public class AppointmentServiceImplementation implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentServiceImplementation(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Optional<Appointment> findOneById(Long userId) {
        return appointmentRepository.findById(userId);
    }

    @Override
    public Optional<Appointment> findOneByDoctorName(String name) {
        return appointmentRepository.findByDoctorName(name);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment create(Appointment newUser) {
        return appointmentRepository.save(newUser);
    }

    @Override
    public void deleteOneById(Long userId) {
        appointmentRepository.deleteById(userId);
    }
}
