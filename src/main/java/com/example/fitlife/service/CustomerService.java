package com.example.fitlife.service;

import com.example.fitlife.model.Customer;

import java.util.List;

public interface CustomerService {
  List<Customer> getAllCustomers();

  Customer getCustomerById(Long id);

  void addCustomer(Customer customer);

  void updateCustomer(Long id, Customer customer);

  void deleteCustomer(Long id);
//  void reserveCourse(Long customerId, Long courseId);
}
