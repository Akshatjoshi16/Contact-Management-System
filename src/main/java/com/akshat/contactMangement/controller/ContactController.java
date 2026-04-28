package com.akshat.contactMangement.controller;

import com.akshat.contactMangement.entity.Contact;
import com.akshat.contactMangement.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContactDetails(@PathVariable Long id){
        Contact contact=contactService.getContactById(id).orElse(null);
        if(contact!=null) {
            return ResponseEntity.ok().body(contact);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> addAllContact(@RequestBody Contact contact) {
        Contact savedContact=contactService.addContact(contact);
        return ResponseEntity.status(201).body(savedContact);
    }

    @PutMapping("contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact){
        Contact updatedContact=contactService.updateContact(id, contact);
        if(updatedContact!=null) {
            return ResponseEntity.ok(updatedContact);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.ok("Contact deleted successfully");
    }
}
