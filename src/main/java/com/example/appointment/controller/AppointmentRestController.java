package com.example.appointment.controller;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/appointment")
public class AppointmentRestController {

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentRestController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    /** GET request to return specific users **/
    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
    public Optional<Appointment> findOne(@PathVariable Long userId) {
        return appointmentRepository.findById(userId);
    }

    /** GET request to return all users **/
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }


    /** POST request to add new users **/
    @RequestMapping(path = "/users", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment create(@RequestBody Appointment newUser) {
        return appointmentRepository.save(newUser);
    }

    /** DELETE request to delete specific users **/
    @RequestMapping(path = "/users/{userId}", method = RequestMethod.DELETE)
    void delete(@PathVariable Long userId) {
        appointmentRepository.deleteById(userId);
    }
}
