package com.example.contactapi.controller;

import com.example.contactapi.model.Contact;
import com.example.contactapi.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Optional<Contact> contact = contactService.getContactById(id);
        if (contact.isPresent()) {
            return ResponseEntity.ok(contact.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Contact>> searchContactsByName(@RequestParam String name) {
        List<Contact> contacts = contactService.searchContactsByName(name);
        return ResponseEntity.ok(contacts);
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody @Valid Contact contact) {
        try {
            Contact createdContact = contactService.createContact(contact);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(
            @PathVariable Long id,
            @RequestBody @Valid Contact contact) {
        try {
            Contact updatedContact = contactService.updateContact(id, contact);
            return ResponseEntity.ok(updatedContact);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Contact> patchContact(
            @PathVariable Long id,
            @RequestBody Contact contact) {
        try {
            Contact updatedContact = contactService.patchContact(id, contact);
            return ResponseEntity.ok(updatedContact);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        try {
            contactService.deleteContact(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
