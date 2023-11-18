package com.example.fitlife.repository;

import com.example.fitlife.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResevationRepo extends JpaRepository<Reservation, Long> {
  List<Reservation> findByCustomer_Id(Long customerId);

}
