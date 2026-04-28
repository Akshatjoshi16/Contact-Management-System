package com.akshat.contactMangement.service;

import com.akshat.contactMangement.entity.Contact;
import com.akshat.contactMangement.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;
    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        Contact existing=contactRepository.findById(id).orElse(null);
        if(existing!=null){
            existing.setName(contact.getName());
            existing.setNumber(contact.getNumber());
            return existing;
        }else throw new RuntimeException("Contact not found!");

    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
