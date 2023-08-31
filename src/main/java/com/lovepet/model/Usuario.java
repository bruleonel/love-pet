package com.lovepet.model;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    // Getters e setters
{

EntityManagerFactory emf = Persistence.createEntityManagerFactory("nome-da-unidade-de-persistencia");
EntityManager em = emf.createEntityManager();

em.getTransaction().begin();
Usuario usuario = new Usuario();
usuario.setNome("Alice");
usuario.setEmail("alice@example.com");
em.persist(usuario);
em.getTransaction().commit();

em.close();
emf.close();}

//Construtores

public Usuario() {
}

public Usuario(String nome, String email) {
    this.nome = nome;
    this.email = email;
}

// Getters e setters

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

}
