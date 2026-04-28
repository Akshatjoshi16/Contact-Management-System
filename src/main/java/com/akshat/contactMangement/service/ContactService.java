package com.akshat.contactMangement.service;

import com.akshat.contactMangement.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ContactService {


    List<Contact> getAllContacts();

    Optional<Contact> getContactById(Long id);

    Contact addContact(Contact contact);

    Contact updateContact(Long id,Contact contact);

    void deleteContact(Long id);
}
