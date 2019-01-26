package com.example.appointment.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
public class Appointment {

    private enum Status {Available, Booked};

    private @Id @GeneratedValue Long id;
    private Timestamp created_at;
    private Date appointment_date;
    private Time appointment_start_time;
    private Time appointment_end_time;
//    private String name_of_doctor;
    private String doctorName;
    private Status selectedStatus = Status.Booked;
    private BigDecimal price;

    public Appointment() {

    }

    public Appointment(String doctorName, Status selectedStatus, BigDecimal price) {
//        this.name_of_doctor = name_of_doctor;
        this.doctorName = doctorName;
        this.selectedStatus = selectedStatus;
        this.price = price;
    }

    public Appointment(String doctorName, BigDecimal price) {
//        this.name_of_doctor = name_of_doctor;
        this.doctorName = doctorName;
        this.price = price;
    }

    public Appointment(Timestamp created_at, Date appointment_date, Time appointment_start_time, Time appointment_end_time, String doctorName, Status selectedStatus, BigDecimal price) {
        this.created_at = created_at;
        this.appointment_date = appointment_date;
        this.appointment_start_time = appointment_start_time;
        this.appointment_end_time = appointment_end_time;
//        this.name_of_doctor = name_of_doctor;
        this.doctorName = doctorName;
        this.selectedStatus = selectedStatus;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    public Time getAppointment_start_time() {
        return appointment_start_time;
    }

    public void setAppointment_start_time(Time appointment_start_time) {
        this.appointment_start_time = appointment_start_time;
    }

    public Time getAppointment_end_time() {
        return appointment_end_time;
    }

    public void setAppointment_end_time(Time appointment_end_time) {
        this.appointment_end_time = appointment_end_time;
    }

    public String getName_of_doctor() {
//        return name_of_doctor;
        return doctorName;
    }

    public void setName_of_doctor(String doctorName) {
//        this.name_of_doctor = name_of_doctor;
        this.doctorName = doctorName;
    }

    public Status getSelectedStatus() {
        return selectedStatus;
    }

    public void setSelectedStatus(Status selectedStatus) {
        this.selectedStatus = selectedStatus;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
