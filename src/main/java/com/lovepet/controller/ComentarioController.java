package com.lovepet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lovepet.model.Comentario;
import com.lovepet.service.ComentarioService;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    @Autowired
    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public List<Comentario> listarComentarios() {
        return comentarioService.listarComentarios();
    }

    @GetMapping("/{id}")
    public Comentario encontrarComentarioPorId(@PathVariable Long id) {
        return comentarioService.encontrarComentarioPorId(id);
    }

    @PostMapping
    public Comentario criarComentario(@RequestBody Comentario comentario) {
        return comentarioService.salvarComentario(comentario);
    }

    @PutMapping("/{id}")
    public Comentario atualizarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        return comentarioService.atualizarComentario(id, comentario);
    }

    @DeleteMapping("/{id}")
    public void excluirComentario(@PathVariable Long id) {
        comentarioService.excluirComentario(id);
    }
}
