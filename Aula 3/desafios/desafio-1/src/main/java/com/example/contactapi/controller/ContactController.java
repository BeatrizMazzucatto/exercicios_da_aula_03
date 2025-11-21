package com.example.contactapi.controller;

import com.example.contactapi.model.Address;
import com.example.contactapi.model.Contact;
import com.example.contactapi.repository.ContactRepository;
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
    private ContactRepository contactRepository;
    
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return ResponseEntity.ok(contacts);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        
        if (contact.isPresent()) {
            return ResponseEntity.ok(contact.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{id}/addresses")
    public ResponseEntity<List<Address>> getContactAddresses(@PathVariable Long id) {
        Optional<Contact> contactOptional = contactRepository.findById(id);
        
        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            List<Address> addresses = contact.getAddresses();
            return ResponseEntity.ok(addresses);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Contact>> searchContactsByName(@RequestParam String name) {
        List<Contact> contacts = contactRepository.findByNomeContainingIgnoreCase(name);
        return ResponseEntity.ok(contacts);
    }
    
    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        if (contactRepository.existsByEmail(contact.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        
        Contact savedContact = contactRepository.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
        Optional<Contact> contactOptional = contactRepository.findById(id);
        
        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            contact.setNome(contactDetails.getNome());
            contact.setTelefone(contactDetails.getTelefone());
            contact.setEmail(contactDetails.getEmail());
            
            Contact updatedContact = contactRepository.save(contact);
            return ResponseEntity.ok(updatedContact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
