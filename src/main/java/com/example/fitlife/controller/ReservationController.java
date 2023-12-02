package com.example.fitlife.controller;

import com.example.fitlife.model.Course;
import com.example.fitlife.model.Customer;
import com.example.fitlife.model.Reservation;
import com.example.fitlife.repository.CourseRepo;
import com.example.fitlife.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private CourseRepo courseRepo;

    @PostMapping("/make")
    public ResponseEntity<Reservation> makeReservation(@RequestParam Long customerId, @RequestParam Long courseId) {
        Reservation reservation = reservationService.makeReservation(customerId, courseId);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Reservation>> getReservationsForCustomer(@PathVariable Long customerId) {
        List<Reservation> reservations = reservationService.getReservationsForCustomer(customerId);
        return ResponseEntity.ok(reservations);
    }
    @DeleteMapping("/{reservationId}")
    public void deleteReservation(@PathVariable Long reservationId) {
        reservationService.deleteReservation(reservationId);
    }

    @GetMapping("/testReservation/{course}/{customer}")
    public boolean testResrvation(@PathVariable("course") Course course, @PathVariable("customer") Customer customer){
        return this.reservationService.testReservation(course,customer);
    }

    @GetMapping("/count")
    public Long contCoach(){ return reservationService.countReservation();}

    @GetMapping("/countbycourse/{course}")
    public Long ReservationByCourse(@PathVariable("course") Course course){ return reservationService.ReservationByCourse(course);}

    @GetMapping("/countbycustomer/{customer}")
    public Long ReservationByCustomer(@PathVariable("customer") Customer customer){ return reservationService.ReservationByCustomer(customer);}
}
