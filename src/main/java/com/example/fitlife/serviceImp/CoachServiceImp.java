package com.example.fitlife.serviceImp;

import com.example.fitlife.model.Coach;
import com.example.fitlife.repository.CoachRepo;
import com.example.fitlife.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class CoachServiceImp implements CoachService {
  @Autowired
  private CoachRepo coachRepository;

  public Coach findById(Long coachId) {
    return coachRepository.findById(coachId)
      .orElseThrow(() -> new NoSuchElementException("Coach not found with ID: " + coachId));
  }
}
