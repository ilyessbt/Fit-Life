package com.example.fitlife.service;

import com.example.fitlife.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContact();
    void addContact(Contact contact);
    Long countContact();
    void deleteContact(Long id);

}
