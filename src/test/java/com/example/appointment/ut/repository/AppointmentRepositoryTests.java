package com.example.appointment.ut.repository;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AppointmentRepository appointmentRepository;


    @Test
    public void whenFindAllByAppointmentDateBetweenOrderByPriceAsc_thenReturnAppointmentSize() {

        Appointment appointmenFirst = new Appointment(LocalDate.of(2019, 2, 3), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"),"Markus", new BigDecimal(90));
        Appointment appointmentSecond = new Appointment(LocalDate.of(2019, 2, 15), Time.valueOf("14:00:00"),  Time.valueOf("15:00:00"),"Thomas", new BigDecimal(60));
        Appointment appointmentThird = new Appointment(LocalDate.of(2019, 1, 23), Time.valueOf("18:00:00"),  Time.valueOf("19:00:00"),"Chris", new BigDecimal(10));

        entityManager.persist(appointmenFirst);
        entityManager.persist(appointmentSecond);
        entityManager.persist(appointmentThird);
        entityManager.flush();

        List<Appointment> appointments = appointmentRepository.findAllByAppointmentDateBetweenOrderByPriceAsc(LocalDate.of(2019, 1, 20), LocalDate.of(2019, 2, 3));

        assertThat(appointments).hasSize(2);

    }

    @Test
    public void whenFindAllByAppointmentDateBetweenOrderByPriceAsc_thenReturnAppointmentName() {

        Appointment appointmenFirst = new Appointment(LocalDate.of(2019, 2, 3), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"),"Markus", new BigDecimal(90));
        Appointment appointmentSecond = new Appointment(LocalDate.of(2019, 2, 15), Time.valueOf("14:00:00"),  Time.valueOf("15:00:00"),"Thomas", new BigDecimal(60));
        Appointment appointmentThird = new Appointment(LocalDate.of(2019, 1, 23), Time.valueOf("18:00:00"),  Time.valueOf("19:00:00"),"Chris", new BigDecimal(10));

        entityManager.persist(appointmenFirst);
        entityManager.persist(appointmentSecond);
        entityManager.persist(appointmentThird);
        entityManager.flush();

        List<Appointment> appointments = appointmentRepository.findAllByAppointmentDateBetweenOrderByPriceAsc(LocalDate.of(2019, 1, 20), LocalDate.of(2019, 2, 3));

        assertThat(appointments).extracting(Appointment::getNameOfDoctor).containsOnly(appointmenFirst.getNameOfDoctor(), appointmentThird.getNameOfDoctor());

    }

    @Test
    public void whenInvalidDate_thenThrowException(){

        Appointment appointmenFirst = new Appointment(LocalDate.of(2019, 2, 3), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"),"Markus", new BigDecimal(90));
        Appointment appointmentSecond = new Appointment(LocalDate.of(2019, 2, 15), Time.valueOf("14:00:00"),  Time.valueOf("15:00:00"),"Thomas", new BigDecimal(60));
        Appointment appointmentThird = new Appointment(LocalDate.of(2019, 1, 23), Time.valueOf("18:00:00"),  Time.valueOf("19:00:00"),"Chris", new BigDecimal(10));

        entityManager.persist(appointmenFirst);
        entityManager.persist(appointmentSecond);
        entityManager.persist(appointmentThird);
        entityManager.flush();

        assertThrows(DateTimeException.class, () -> {
            appointmentRepository.findAllByAppointmentDateBetweenOrderByPriceAsc(LocalDate.of(20, 1, 2019), LocalDate.of(2019, 22, 32));
        });
    }

}
