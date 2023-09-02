package com.lovepet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lovepet.model.Postagem;
import com.lovepet.service.PostagemService;

import java.util.List;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    private final PostagemService postagemService;

    @Autowired
    public PostagemController(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    @GetMapping
    public List<Postagem> listarPostagens() {
        return postagemService.listarPostagens();
    }

    @GetMapping("/{id}")
    public Postagem encontrarPostagemPorId(@PathVariable Long id) {
        return postagemService.encontrarPostagemPorId(id);
    }

    @PostMapping
    public Postagem criarPostagem(@RequestBody Postagem postagem) {
        return postagemService.salvarPostagem(postagem);
    }

    @PutMapping("/{id}")
    public Postagem atualizarPostagem(@PathVariable Long id, @RequestBody Postagem postagem) {
        return postagemService.atualizarPostagem(id, postagem);
    }

    @DeleteMapping("/{id}")
    public void excluirPostagem(@PathVariable Long id) {
        postagemService.excluirPostagem(id);
    }
}
