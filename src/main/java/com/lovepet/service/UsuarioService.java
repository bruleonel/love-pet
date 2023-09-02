package com.lovepet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovepet.model.Usuario;
import com.lovepet.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario encontrarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizarUsuario(Long id, Usuario novoUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNome(novoUsuario.getNome());
            usuario.setEmail(novoUsuario.getEmail());
            // Outros campos que você deseja atualizar

            return usuarioRepository.save(usuario);
        } else {
            throw new IllegalArgumentException("Usuário não encontrado com o ID: " + id);
        }
    }
}
