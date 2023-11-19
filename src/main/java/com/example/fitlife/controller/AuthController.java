package com.example.fitlife.controller;

import com.example.fitlife.model.Customer;
import com.example.fitlife.serviceImp.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("")
public class AuthController {
  @Autowired
  private CustomerServiceImp customerService;
  @PostMapping("/signup")
  public void addCustomer(@RequestBody Customer customer) {
    customerService.addCustomer(customer);
  }
  @PostMapping("/login")
  public String login(@RequestBody Customer loginRequest) {
    Customer user = customerService.findByEmail(loginRequest.getEmail());

    if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
      return "Login successful!";
    } else {
      return "Invalid email or password";
    }
  }
}
