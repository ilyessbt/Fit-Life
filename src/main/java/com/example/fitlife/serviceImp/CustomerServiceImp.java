package com.example.fitlife.serviceImp;

import com.example.fitlife.model.Coach;
import com.example.fitlife.model.Course;
import com.example.fitlife.model.Customer;
import com.example.fitlife.repository.CourseRepo;
import com.example.fitlife.repository.CustomerRepo;
import com.example.fitlife.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {

  @Autowired
  private CustomerRepo customerRepository;
  @Autowired
  private CourseRepo courseRepo;
  @Override
  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Customer getCustomerById(Long id) {
    Optional<Customer> optionalCustomer = customerRepository.findById(id);
    return optionalCustomer.orElse(null);
  }

  @Override
  public void addCustomer(Customer customer) {
    customerRepository.save(customer);
  }
  @Override
  public Customer updateCustomerPartial(Long id, Customer updatedCustomer) {
    Optional<Customer> existingCustomerOptional = customerRepository.findById(id);
    if (existingCustomerOptional.isPresent()){
      Customer existingCustomer = existingCustomerOptional.get();
      if (updatedCustomer.getFullname() != null) {
        existingCustomer.setFullname(updatedCustomer.getFullname());
      }

      if (updatedCustomer.getProfilepic() != null) {
        existingCustomer.setProfilepic(updatedCustomer.getProfilepic());
      }

      if (updatedCustomer.getPhonenumber() != null) {
        existingCustomer.setPhonenumber(updatedCustomer.getPhonenumber());
      }

      return customerRepository.save(existingCustomer);


    }else {
      return null;
    }

  }

  @Override
  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }

  @Override
  public Customer findByEmail(String email) {
    return customerRepository.findByEmail(email);
  }
}
