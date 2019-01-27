package com.example.appointment.repository;

import com.example.appointment.model.Appointment;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Configuration
@Slf4j
public class LoadDataRepository {

    static final private Logger logger = LoggerFactory.getLogger(LoadDataRepository.class);

    @Bean
    CommandLineRunner initDatabase(AppointmentRepository appointmentRepository) {
        return args -> {
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2019, 2, 3), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"),"Markus", new BigDecimal(90))));
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2019, 2, 15), Time.valueOf("14:00:00"),  Time.valueOf("15:00:00"),"Thomas", new BigDecimal(60))));
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2019, 1, 10), Time.valueOf("08:00:00"),  Time.valueOf("09:00:00"),"Mikkel", new BigDecimal(30))));
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2019, 1, 23), Time.valueOf("18:00:00"),  Time.valueOf("19:00:00"),"Chris", new BigDecimal(10))));
        };
    }
}
