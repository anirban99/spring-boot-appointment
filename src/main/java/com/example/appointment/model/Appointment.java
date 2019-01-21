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

    private @Id @GeneratedValue Long id;
    private Timestamp created_at;
    private Date appointment_date;
    private Time appointment_duration;
    private String name_of_doctor;
    private Enum status;
    private BigDecimal price;

    public Appointment() {

    }

    public Appointment(Timestamp created_at, Date appointment_date, Time appointment_duration, String name_of_doctor, Enum status, BigDecimal price) {
        this.created_at = created_at;
        this.appointment_date = appointment_date;
        this.appointment_duration = appointment_duration;
        this.name_of_doctor = name_of_doctor;
        this.status = status;
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

    public Time getAppointment_duration() {
        return appointment_duration;
    }

    public void setAppointment_duration(Time appointment_duration) {
        this.appointment_duration = appointment_duration;
    }

    public String getName_of_doctor() {
        return name_of_doctor;
    }

    public void setName_of_doctor(String name_of_doctor) {
        this.name_of_doctor = name_of_doctor;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
