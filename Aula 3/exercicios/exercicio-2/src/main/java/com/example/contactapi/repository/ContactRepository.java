package com.example.contactapi.repository;

import com.example.contactapi.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    
    List<Contact> findByNomeContainingIgnoreCase(String nome);
    
    Contact findByEmail(String email);
    
    boolean existsByEmail(String email);
}
