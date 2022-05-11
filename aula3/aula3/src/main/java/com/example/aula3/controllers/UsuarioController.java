package com.example.aula3.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import com.example.aula3.dto.AutenticacaoDTO;
import com.example.aula3.dto.DadosUsuarioDTO;
import com.example.aula3.dto.TokenDTO;
import com.example.aula3.dto.UsuarioDTO;
import com.example.aula3.entity.Usuario;
import com.example.aula3.exceptions.SenhaInvalidaException;
import com.example.aula3.security.jwt.JwtService;
import com.example.aula3.services.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;
    private JwtService jwtService;

    public UsuarioController(UsuarioService usuarioService, JwtService jwtService) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@Valid @RequestBody UsuarioDTO dto) {
        Usuario usuario = usuarioService.salvar(dto);
        return usuario.getId();
    }

    @GetMapping("{id}")
    public DadosUsuarioDTO getById(@PathVariable Integer id) {
        return usuarioService.obterUsuarioPorId(id);
    }

    @GetMapping
    public ArrayList<DadosUsuarioDTO> getAll() {
        return usuarioService.obterUsuarios();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        usuarioService.remover(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void edit(@PathVariable Integer id, @RequestBody UsuarioDTO dto) {
        usuarioService.editar(id, dto);
    }

  
}
