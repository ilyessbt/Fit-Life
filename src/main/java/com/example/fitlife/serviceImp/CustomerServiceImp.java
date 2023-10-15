package com.example.fitlife.serviceImp;

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
  public void updateCustomer(Long id, Customer updatedCustomer) {
    Optional<Customer> optionalCustomer = customerRepository.findById(id);

    if (optionalCustomer.isPresent()) {
      Customer existingCustomer = optionalCustomer.get();
      existingCustomer.setFullname(updatedCustomer.getFullname());
      existingCustomer.setProfilepic(updatedCustomer.getProfilepic());
      existingCustomer.setPhonenumber(updatedCustomer.getPhonenumber());
      existingCustomer.setEmail(updatedCustomer.getEmail());
      existingCustomer.setPassword(updatedCustomer.getPassword());

      customerRepository.save(existingCustomer);
    }
  }

  @Override
  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }

//  @Override
//  public void reserveCourse(Long customerId, Long courseId) {
//    Customer customer = customerRepository.findById(customerId).orElse(null);
//    Course course = courseRepo.findById(courseId).orElse(null);
//
//    if (customer != null && course != null) {
//      customer.getCourses().add(course);
//      course.getCustomers().add(customer);
//      customerRepository.save(customer);
//    }
//  }
}
