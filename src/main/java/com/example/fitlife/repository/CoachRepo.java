package com.example.fitlife.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fitlife.model.Coach;


public interface CoachRepo extends JpaRepository<Coach,Long> {
}
