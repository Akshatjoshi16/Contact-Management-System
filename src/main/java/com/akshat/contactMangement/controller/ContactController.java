package com.akshat.contactMangement.controller;

import com.akshat.contactMangement.entity.Contact;
import com.akshat.contactMangement.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public List<Contact> getAllContacts(){

    }
}
