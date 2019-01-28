package com.example.appointment.ut.service;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentRepository;
import com.example.appointment.service.AppointmentService;
import com.example.appointment.service.AppointmentServiceImplementation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class AppointmentServiceImplementationTests {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public AppointmentService appointmentService() {
            return new AppointmentServiceImplementation();
        }
    }

    @Autowired
    private AppointmentService appointmentService;

    @MockBean
    private AppointmentRepository appointmentRepository;

    @Before
    public void setUp() {

        Appointment appointmenFirst = new Appointment(LocalDate.of(2019, 2, 3), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"),"Markus", new BigDecimal(90));
        Appointment appointmentSecond = new Appointment(LocalDate.of(2019, 2, 15), Time.valueOf("14:00:00"),  Time.valueOf("15:00:00"),"Thomas", new BigDecimal(60));
        Appointment appointmentThird = new Appointment(LocalDate.of(2019, 1, 23), Time.valueOf("18:00:00"),  Time.valueOf("19:00:00"),"Chris", new BigDecimal(10));

        List<Appointment> allAppointments = Arrays.asList(appointmenFirst, appointmentSecond, appointmentThird);

        Mockito.when(appointmentRepository.findById(appointmenFirst.getId())).thenReturn(Optional.of(appointmenFirst));
        Mockito.when(appointmentRepository.findAll()).thenReturn(allAppointments);
        Mockito.when(appointmentRepository.findById(-99L)).thenReturn(Optional.empty());
    }

    @Test
    public void whenInValidId_thenAppointmentShouldNotBeFound() {

        appointmentService.create(new Appointment(LocalDate.of(2019, 2, 3), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"),"Markus", new BigDecimal(90)));
        appointmentService.create(new Appointment(LocalDate.of(2019, 2, 15), Time.valueOf("14:00:00"),  Time.valueOf("15:00:00"),"Thomas", new BigDecimal(60)));
        appointmentService.create(new Appointment(LocalDate.of(2019, 1, 23), Time.valueOf("18:00:00"),  Time.valueOf("19:00:00"),"Chris", new BigDecimal(10)));

        Optional<Appointment> appointment = appointmentService.findById(Long.valueOf(-99));
        verifyFindByIdIsCalledOnce();
        assertThat(appointment).isEmpty();
    }

    @Test
    public void whenFindAll_thenReturnAllRecords() {
        Appointment appointmenFirst = new Appointment(LocalDate.of(2019, 2, 3), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"),"Markus", new BigDecimal(90));
        Appointment appointmentSecond = new Appointment(LocalDate.of(2019, 2, 15), Time.valueOf("14:00:00"),  Time.valueOf("15:00:00"),"Thomas", new BigDecimal(60));
        Appointment appointmentThird = new Appointment(LocalDate.of(2019, 1, 23), Time.valueOf("18:00:00"),  Time.valueOf("19:00:00"),"Chris", new BigDecimal(10));

        List<Appointment> allAppointments = appointmentService.findAll();
        verifyFindAllEmployeesIsCalledOnce();
        assertThat(allAppointments).hasSize(3).extracting(Appointment::getNameOfDoctor).contains(appointmenFirst.getNameOfDoctor(), appointmentSecond.getNameOfDoctor(), appointmentThird.getNameOfDoctor());
    }


    private void verifyFindByIdIsCalledOnce() {
        Mockito.verify(appointmentRepository, VerificationModeFactory.times(1)).findById(Mockito.anyLong());
        Mockito.reset(appointmentRepository);
    }

    private void verifyFindAllEmployeesIsCalledOnce() {
        Mockito.verify(appointmentRepository, VerificationModeFactory.times(1)).findAll();
        Mockito.reset(appointmentRepository);
    }

}
