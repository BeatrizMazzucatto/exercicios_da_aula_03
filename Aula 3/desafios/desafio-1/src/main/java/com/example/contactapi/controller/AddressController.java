package com.example.contactapi.controller;

import com.example.contactapi.model.Address;
import com.example.contactapi.model.Contact;
import com.example.contactapi.repository.AddressRepository;
import com.example.contactapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin(origins = "*")
public class AddressController {
    
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private ContactRepository contactRepository;
    
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return ResponseEntity.ok(addresses);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> address = addressRepository.findById(id);
        
        if (address.isPresent()) {
            return ResponseEntity.ok(address.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        if (address.getContact() == null || address.getContact().getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        
        Optional<Contact> contactOptional = contactRepository.findById(address.getContact().getId());
        if (contactOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        Contact contact = contactOptional.get();
        address.setContact(contact);
        
        Address savedAddress = addressRepository.save(address);
        
        contact.addAddress(savedAddress);
        contactRepository.save(contact);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address addressDetails) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        
        if (addressOptional.isPresent()) {
            Address address = addressOptional.get();
            address.setRua(addressDetails.getRua());
            address.setCidade(addressDetails.getCidade());
            address.setEstado(addressDetails.getEstado());
            address.setCep(addressDetails.getCep());
            
            if (addressDetails.getContact() != null && addressDetails.getContact().getId() != null) {
                Optional<Contact> contactOptional = contactRepository.findById(addressDetails.getContact().getId());
                if (contactOptional.isPresent()) {
                    address.setContact(contactOptional.get());
                } else {
                    return ResponseEntity.notFound().build();
                }
            }
            
            Address updatedAddress = addressRepository.save(address);
            return ResponseEntity.ok(updatedAddress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        
        if (addressOptional.isPresent()) {
            Address address = addressOptional.get();
            
            if (address.getContact() != null) {
                address.getContact().removeAddress(address);
                contactRepository.save(address.getContact());
            }
            
            addressRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/search/city")
    public ResponseEntity<List<Address>> getAddressesByCity(@RequestParam String cidade) {
        List<Address> addresses = addressRepository.findByCidade(cidade);
        return ResponseEntity.ok(addresses);
    }
    
    @GetMapping("/search/state")
    public ResponseEntity<List<Address>> getAddressesByState(@RequestParam String estado) {
        List<Address> addresses = addressRepository.findByEstado(estado);
        return ResponseEntity.ok(addresses);
    }
    
    @GetMapping("/search/zipcode")
    public ResponseEntity<List<Address>> getAddressesByZipCode(@RequestParam String cep) {
        List<Address> addresses = addressRepository.findByCep(cep);
        return ResponseEntity.ok(addresses);
    }
}
