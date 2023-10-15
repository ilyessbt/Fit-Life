package com.example.fitlife.controller;

import com.example.fitlife.model.Customer;
import com.example.fitlife.serviceImp.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @PostMapping("/")
  public void addCustomer(@RequestBody Customer customer) {
    customerService.addCustomer(customer);
  }

  @PutMapping("/{id}")
  public void updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
    customerService.updateCustomer(id, customer);
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
  }

//  @PostMapping("/reserve")
//  public void reserveCourse(@RequestParam Long customerId, @RequestParam Long courseId) {
//    customerService.reserveCourse(customerId, courseId);
//  }
}
