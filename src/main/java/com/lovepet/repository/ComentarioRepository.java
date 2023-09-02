package com.lovepet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lovepet.model.Comentario; // Importe a classe Comentario correta

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    // Métodos de consulta personalizados, se necessário
}
