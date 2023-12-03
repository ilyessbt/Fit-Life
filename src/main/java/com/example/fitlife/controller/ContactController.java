package com.example.fitlife.controller;

import com.example.fitlife.model.Contact;
import com.example.fitlife.model.Customer;
import com.example.fitlife.service.ContactService;
import com.example.fitlife.serviceImp.ContactServiceImp;
import com.example.fitlife.serviceImp.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactServiceImp ContactService;

    @PostMapping("/add")
    public void addContact(@RequestBody Contact Contact) {
        ContactService.addContact(Contact);
    }

    @GetMapping("/")
    public List<Contact> getAllContact() {
        return ContactService.getAllContact();
    }
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        ContactService.deleteContact(id);
    }

    @GetMapping("/count")
    public Long contContact(){ return ContactService.countContact();}
}

