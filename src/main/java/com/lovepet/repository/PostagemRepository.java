package com.lovepet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lovepet.model.Postagem; // Importe a classe Postagem correta

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    // Métodos de consulta personalizados, se necessário
}

