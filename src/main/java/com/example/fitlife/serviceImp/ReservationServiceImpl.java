package com.example.fitlife.serviceImp;

import com.example.fitlife.model.Course;
import com.example.fitlife.model.Customer;
import com.example.fitlife.model.Reservation;
import com.example.fitlife.repository.CourseRepo;
import com.example.fitlife.repository.CustomerRepo;
import com.example.fitlife.repository.ResevationRepo;
import com.example.fitlife.service.ReservationService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private CourseRepo courseRepository;

    @Autowired
    private ResevationRepo reservationRepository;

    @Override
    @Transactional
    public Reservation makeReservation(Long customerId, Long courseId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + courseId));
        if (course.getSpots() > 0 ) {
            Reservation reservation = new Reservation();
            reservation.setCustomer(customer);
            reservation.setCourse(course);
            course.setSpots(course.getSpots() - 1);
            courseRepository.save(course);
            return reservationRepository.save(reservation);
        } else {
            course.setAvailability(false);
            throw new RuntimeException("No available spots for the course with id: " + courseId);
        }


    }

    @Override
    public boolean testReservation(Course course, Customer customer) {
        long x = reservationRepository.testreservation(course, customer);
        if (x>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    @Override
    public List<Reservation> getReservationsForCustomer(Long customerId) {
        return reservationRepository.findByCustomer_Id(customerId);
    }

    @Override
    @Transactional
    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}