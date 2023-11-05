package com.example.fitlife.controller;

import com.example.fitlife.model.Coach;
import com.example.fitlife.serviceImp.CoachServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/coaches")
public class CoachController {

  @Autowired
  private CoachServiceImp coachService;

  @GetMapping("/{id}")
  public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
    try {
      Coach coach = coachService.findById(id);
      return new ResponseEntity<>(coach, HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
