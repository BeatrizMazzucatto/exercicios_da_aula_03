package com.example.contactapi.service;

import com.example.contactapi.model.Contact;
import com.example.contactapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public List<Contact> searchContactsByName(String nome) {
        return contactRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Contact createContact(Contact contact) {
        Optional<Contact> existingContact = contactRepository.findByEmail(contact.getEmail());
        if (existingContact.isPresent()) {
            throw new IllegalArgumentException("Já existe um contato com o e-mail: " + contact.getEmail());
        }
        
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact contact) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com ID: " + id));
        existingContact.setNome(contact.getNome());
        existingContact.setTelefone(contact.getTelefone());
        existingContact.setEmail(contact.getEmail());
        
        return contactRepository.save(existingContact);
    }

    public Contact patchContact(Long id, Contact contact) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com ID: " + id));
        if (contact.getNome() != null && !contact.getNome().isEmpty()) {
            existingContact.setNome(contact.getNome());
        }
        if (contact.getTelefone() != null && !contact.getTelefone().isEmpty()) {
            existingContact.setTelefone(contact.getTelefone());
        }
        if (contact.getEmail() != null && !contact.getEmail().isEmpty()) {
            existingContact.setEmail(contact.getEmail());
        }
        
        return contactRepository.save(existingContact);
    }

    public void deleteContact(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new RuntimeException("Contato não encontrado com ID: " + id);
        }
        contactRepository.deleteById(id);
    }
}

