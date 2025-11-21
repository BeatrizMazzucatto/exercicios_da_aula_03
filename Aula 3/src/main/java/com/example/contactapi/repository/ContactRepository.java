package com.example.contactapi.repository;

import com.example.contactapi.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByNomeContainingIgnoreCase(String nome);

    Optional<Contact> findByEmail(String email);
}

