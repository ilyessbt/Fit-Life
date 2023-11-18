package com.example.fitlife.service;

import com.example.fitlife.model.Reservation;

import java.util.List;

public interface ReservationService {
  Reservation makeReservation(Long customerId, Long courseId);
  List<Reservation> getAllReservations();
  List<Reservation> getReservationsForCustomer(Long customerId);
  void deleteReservation(Long reservationId);

}
