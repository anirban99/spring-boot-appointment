package com.example.appointment.service;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentCustomRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.Optional;

public class AppointmentCustomServiceImplementation implements AppointmentCustomRepository {

    @Override
    public Optional<Appointment> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate) {
        //        Select * from appointment where appointmentDate between startDate and endDate sorted by price

        System.out.println("-- Find All by Date Range --");
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
////        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Appointment> criteriaQuery = criteriaBuilder.createQuery(Appointment.class);
//        Root<Appointment> appointmentList = criteriaQuery.from(Appointment.class);
//
//        Path<LocalDate> appointmentDate = appointmentList.get("appointmentDate");
//        Predicate predicate = criteriaBuilder.between(appointmentDate,startDate,endDate);
//        criteriaQuery.select(appointmentList).where(predicate);
//
//        Query query = entityManager.createQuery(criteriaQuery);
//        System.out.println("The query results");
//        System.out.println(query.getResultList());
//        entityManager.close();

        return null;
    }
}
