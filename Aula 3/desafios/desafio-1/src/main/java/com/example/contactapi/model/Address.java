package com.example.contactapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String rua;
    
    @Column(nullable = false)
    private String cidade;
    
    @Column(nullable = false)
    private String estado;
    
    @Column(nullable = false)
    private String cep;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;
    
    public Address() {}
    
    public Address(String rua, String cidade, String estado, String cep, Contact contact) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.contact = contact;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getRua() {
        return rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getCep() {
        return cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public Contact getContact() {
        return contact;
    }
    
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", contactId=" + (contact != null ? contact.getId() : null) +
                '}';
    }
}
