package com.example.fitlife.service;

import com.example.fitlife.model.Course;
import com.example.fitlife.model.Customer;
import com.example.fitlife.model.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation makeReservation(Long customerId, Long courseId);

    boolean testReservation(Course course, Customer customer);

    List<Reservation> getAllReservations();
    List<Reservation> getReservationsForCustomer(Long customerId);
    void deleteReservation(Long reservationId);

    Customer findByEmail(String email);
}
