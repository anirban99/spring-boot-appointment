package com.example.appointment.controller;

//import com.example.appointment.Exceptions.ResourceNotFoundException;
import com.example.appointment.model.Appointment;
import com.example.appointment.model.AppointmentStatus;
import com.example.appointment.service.AppointmentService;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentRestController {

    @Autowired
    private AppointmentService appointmentService;

    public AppointmentRestController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    /** GET request to return specific appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.GET)
    public Optional<Appointment> findById(@PathVariable Long appointmentId) {
        return appointmentService.findById(appointmentId);
    }

    /** GET request to return all appointments **/
    @RequestMapping(path = "/", method = RequestMethod.GET)
    List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    /** GET request to return all appointments based on a date range and ordered by price **/
    @RequestMapping(method = RequestMethod.GET)
    public List<Appointment> findByDateRangeSortedByPrice(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("startDate") LocalDate startDate,
                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate") LocalDate endDate) {
        return appointmentService.findByDateRangeSortedByPrice(startDate, endDate);
    }

    /** POST request to add new appointments **/
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment create(@RequestBody Appointment appointment) {
        return appointmentService.create(appointment);
    }

    /** PUT request to update appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Appointment update(@PathVariable Long appointmentId, @RequestBody Appointment appointment) {
        return appointmentService.update(appointmentId, appointment);
    }

//    /** PATCH request to update status of an appointment **/
//    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.PATCH, consumes = "application/json")
//    @ResponseStatus(HttpStatus.OK)
//    public String updateStatus(@PathVariable Long appointmentId, @RequestBody Appointment appointment) throws ResourceNotFoundException {
//
////        MultiValueMap<String, String> formParams
////        long id = Long.parseLong(formParams.getFirst("appointmentId"));
//////        String status = formParams.getFirst("status");
////        AppointmentStatus status = Enum.valueOf(AppointmentStatus.class, formParams.getFirst("status"));
////        appointmentService.updateStatus(id, status);
//
//        appointmentService.updateStatus(appointmentId, appointment);
//        return "Status Updated";
//    }

    /** DELETE request to delete specific appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable Long appointmentId) {
        appointmentService.deleteById(appointmentId);
    }
}
