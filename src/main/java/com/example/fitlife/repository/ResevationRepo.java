package com.example.fitlife.repository;


import com.example.fitlife.model.Course;
import com.example.fitlife.model.Customer;
import com.example.fitlife.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ResevationRepo extends JpaRepository<Reservation, Long> {

    List<Reservation> findByCustomer_Id(Long customerId);

    @Query("SELECT count(r) FROM Reservation r WHERE r.course = :course and r.customer = :customer ")
    long testreservation(@Param("course") Course course, @Param("customer") Customer customer);

    @Query("SELECT count(r) FROM Reservation r WHERE r.course = :course")
    long ReservationByCourse(@Param("course") Course course);

    @Query("SELECT count(r) FROM Reservation r WHERE r.customer = :customer ")
    long ReservationByCustomer(@Param("customer") Customer customer);


}

