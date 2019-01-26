package com.example.appointment.controller;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentRepository;
import com.example.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/appointment")
public class AppointmentRestController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentRestController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    /** GET request to return specific users **/
    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
    public Optional<Appointment> findOneById(@PathVariable Long userId) {
        return appointmentService.findOneById(userId);
    }

    /** GET request to return specific users **/
    @RequestMapping(path = "/doctors/{name}", method = RequestMethod.GET)
    public Optional<Appointment> findOneByDoctorName(@PathVariable String name) {
        return appointmentService.findOneByDoctorName(name);
    }

    /** GET request to return all users **/
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    List<Appointment> findAll() {
        return appointmentService.findAll();
    }


    /** POST request to add new users **/
    @RequestMapping(path = "/users", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment create(@RequestBody Appointment newUser) {
        return appointmentService.create(newUser);
    }

    /** DELETE request to delete specific users **/
    @RequestMapping(path = "/users/{userId}", method = RequestMethod.DELETE)
    void deleteOneById(@PathVariable Long userId) {
        appointmentService.deleteOneById(userId);
    }
}
