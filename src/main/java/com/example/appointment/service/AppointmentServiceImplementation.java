package com.example.appointment.service;

import com.example.appointment.Exceptions.ResourceNotFoundException;
import com.example.appointment.model.Appointment;
import com.example.appointment.model.AppointmentStatus;
import com.example.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component("appointmentService")
public class AppointmentServiceImplementation implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentServiceImplementation(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Optional<Appointment> findById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate) {
        return appointmentRepository.findAllByAppointmentDateBetweenOrderByPriceAsc(startDate, endDate);
    }

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Long appointmentId, Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

//    @Override
//    public void updateStatus(Long appointmentId, AppointmentStatus status) {
//
//        Map<Long, Appointment> appointmentMap = new HashMap<>();
//        Appointment appointment = appointmentMap.get(appointmentId);
////        Appointment.availableStatus availableStatus = Appointment.availableStatus.valueOf(status);
//        appointment.setStatus(status);
//    }

//    @Override
//    public void updateStatus(Long appointmentId, Appointment appointment) throws ResourceNotFoundException {
//
//       Appointment appointments = appointmentRepository.findById(appointmentId).
//           orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + appointmentId));
//
//       appointments.setStatus(appointment.getStatus());
//       appointmentRepository.save(appointments);
//    }

    @Override
    public void deleteById(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
