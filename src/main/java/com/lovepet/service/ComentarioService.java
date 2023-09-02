package com.lovepet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lovepet.model.Comentario;
import com.lovepet.repository.ComentarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario salvarComentario(Comentario comentario) {
        // Adicione validações ou lógica de negócios antes de salvar, se necessário
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> listarComentarios() {
        return comentarioRepository.findAll();
    }

    public void excluirComentario(Long id) {
        // Verifique se o comentário existe antes de excluir
        if (comentarioRepository.existsById(id)) {
            comentarioRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Comentário não encontrado com o ID: " + id);
        }
    }

    public Comentario atualizarComentario(Long id, Comentario novoComentario) {
        Optional<Comentario> comentarioExistente = comentarioRepository.findById(id);

        if (comentarioExistente.isPresent()) {
            Comentario comentario = comentarioExistente.get();
            comentario.setConteudo(novoComentario.getConteudo());
            // Outros campos que você deseja atualizar

            // Adicione validações ou lógica de negócios antes de salvar, se necessário
            return comentarioRepository.save(comentario);
        } else {
            throw new IllegalArgumentException("Comentário não encontrado com o ID: " + id);
        }
    }

    public Comentario encontrarComentarioPorId(Long id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comentário não encontrado com o ID: " + id));
    }
}
