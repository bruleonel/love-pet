package com.lovepet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conteudo;
    private Date dataComentario;

    @ManyToOne
    private Usuario autor; // Relação com a entidade Usuario


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(Date dataComentario) {
        this.dataComentario = dataComentario;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
}
