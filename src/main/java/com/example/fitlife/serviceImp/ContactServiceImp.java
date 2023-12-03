package com.example.fitlife.serviceImp;

import com.example.fitlife.model.Contact;
import com.example.fitlife.model.Customer;
import com.example.fitlife.repository.ContactRepo;
import com.example.fitlife.service.ContactService;
import com.example.fitlife.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImp implements ContactService {
    @Autowired
    private ContactRepo ContactRepository;

    @Override
    public List<Contact> getAllContact() {
        return ContactRepository.findAll();
    }
    @Override
    public void addContact(Contact contact) {
        ContactRepository.save(contact);
    }
    @Override
    public Long countContact() {
        return ContactRepository.count();
    }
    @Override
    public void deleteContact(Long id) {
        ContactRepository.deleteById(id);
    }

}
