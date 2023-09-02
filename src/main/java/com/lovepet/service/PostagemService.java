package com.lovepet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovepet.model.Postagem;
import com.lovepet.model.Usuario;
import com.lovepet.repository.PostagemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {

    private final PostagemRepository postagemRepository;

    @Autowired
    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }


    public Postagem salvarPostagem(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public List<Postagem> listarPostagens() {
        return postagemRepository.findAll();
    }

    public void excluirPostagem(Long id) {
        postagemRepository.deleteById(id);
    }
    
    public Postagem encontrarPostagemPorId(Long id) {
        return postagemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Postagem não encontrada com o ID: " + id));
    }

    public Postagem atualizarPostagem(Long id, Postagem novaPostagem) {
        Optional<Postagem> postagemExistente = postagemRepository.findById(id);

        if (postagemExistente.isPresent()) {
            Postagem postagem = postagemExistente.get();
            postagem.setConteudo(novaPostagem.getConteudo());
            // Outros campos que você deseja atualizar

            return postagemRepository.save(postagem);
        } else {
            throw new IllegalArgumentException("Postagem não encontrada com o ID: " + id);
        }
    }
}

