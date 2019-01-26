package com.example.appointment.repository;

import com.example.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByDoctorName(String name);

    Optional<Appointment> findAllByAppointment_dateAndAndAppointment_dateOrderByPriceAsc(Date startAppointmentDate, Date endAppointmentDate);
}
