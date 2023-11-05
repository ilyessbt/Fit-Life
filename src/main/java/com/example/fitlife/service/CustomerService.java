package com.example.fitlife.service;

import com.example.fitlife.model.Customer;

import java.util.List;

public interface CustomerService {
  List<Customer> getAllCustomers();

  Customer getCustomerById(Long id);

  void addCustomer(Customer customer);

  Customer updateCustomerPartial(Long id, Customer updatedCustomer);

  void deleteCustomer(Long id);
}
