package com.example.contactapi.repository;

import com.example.contactapi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
    List<Address> findByContactId(Long contactId);
    
    List<Address> findByCidade(String cidade);
    
    List<Address> findByEstado(String estado);
    
    List<Address> findByCep(String cep);
    
    @Query("SELECT a FROM Address a JOIN FETCH a.contact WHERE a.contact.id = :contactId")
    List<Address> findByContactIdWithContact(@Param("contactId") Long contactId);
    
    long countByContactId(Long contactId);
}
