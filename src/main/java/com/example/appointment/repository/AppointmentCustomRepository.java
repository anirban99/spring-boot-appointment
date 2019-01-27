package com.example.appointment.repository;

import com.example.appointment.model.Appointment;

import java.time.LocalDate;
import java.util.Optional;

public interface AppointmentCustomRepository {

    Optional<Appointment> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate);
}
