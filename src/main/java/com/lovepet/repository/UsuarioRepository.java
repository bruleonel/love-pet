package com.lovepet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lovepet.model.Usuario;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	List<Usuario> findByNome(String nome);
	 
	Usuario findByEmail(String email);
	   
	List<Usuario> findByNomeContaining(String parteDoNome);
}
