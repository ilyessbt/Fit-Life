package com.example.fitlife.repository;

import com.example.fitlife.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends JpaRepository<Customer,Long> {


    Customer findByEmail(String email);

  }



