package com.example.fitlife.repository;

import com.example.fitlife.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepo extends JpaRepository<Coach,Long> {
}
