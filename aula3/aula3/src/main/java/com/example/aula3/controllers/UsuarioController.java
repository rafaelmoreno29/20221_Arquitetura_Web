package com.example.aula3.controllers;

import com.example.aula3.dto.DadosUsuarioDTO;
import com.example.aula3.dto.UsuarioDTO;
import com.example.aula3.entity.Usuario;
import com.example.aula3.services.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save (@RequestBody UsuarioDTO dto){
        Usuario usuario = usuarioService.salvar(dto);
        return usuario.getId();
    }

    @GetMapping("{id}")
    public DadosUsuarioDTO getById(@PathVariable Integer id){
        return usuarioService.obterUsuario(id);
    }
}
