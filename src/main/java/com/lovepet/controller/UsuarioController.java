package com.lovepet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lovepet.model.Usuario;
import com.lovepet.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public Usuario encontrarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.encontrarUsuarioPorId(id);
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
    }
}
