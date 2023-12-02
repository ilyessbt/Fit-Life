package com.example.fitlife.controller;

import com.example.fitlife.model.Customer;
import com.example.fitlife.serviceImp.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  private CustomerServiceImp customerService;

  @GetMapping("/")
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable Long id) {
    return customerService.getCustomerById(id);
  }


  @PatchMapping("/{id}")
  public ResponseEntity<Customer> partialUpdateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
    try {
      Customer customer = customerService.updateCustomerPartial(id, updatedCustomer);
      return new ResponseEntity<>(customer, HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
  }

  @GetMapping("/count")
  public Long contCoach(){ return customerService.countCustomer();}
  }



