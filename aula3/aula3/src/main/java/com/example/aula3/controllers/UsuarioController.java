package com.example.aula3.controllers;

import java.util.Optional;

import com.example.aula3.entity.Usuario;
import com.example.aula3.repository.UsuarioRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * UsuarioController
 */
@Controller
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @RequestMapping(value = { "/hello/{nome}"}, method = RequestMethod.GET)
    @ResponseBody
    public String helloUsuario(@PathVariable("nome") String nomeUsuario) {
        return String.format("Hello %s", nomeUsuario);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent())
            return ResponseEntity.ok(usuario.get());
        
            return ResponseEntity.notFound().build();
    }
}