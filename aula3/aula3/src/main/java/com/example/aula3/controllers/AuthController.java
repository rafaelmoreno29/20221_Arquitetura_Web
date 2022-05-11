package com.example.aula3.controllers;

import com.example.aula3.dto.AutenticacaoDTO;
import com.example.aula3.dto.TokenDTO;
import com.example.aula3.entity.Usuario;
import com.example.aula3.exceptions.SenhaInvalidaException;
import com.example.aula3.security.jwt.JwtService;
import com.example.aula3.services.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private UsuarioService usuarioService;
    private JwtService jwtService;

    public AuthController(UsuarioService usuarioService, JwtService jwtService) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    @PostMapping()
    public TokenDTO autenticar(@RequestBody AutenticacaoDTO autenticacao) {
        try {
            Usuario usuario = new Usuario(0, "", autenticacao.getEmail(), autenticacao.getSenha());
            UserDetails usuarioAutenticado = usuarioService.autenticar(usuario);
            String token = jwtService.gerarToken(usuario);
            return new TokenDTO(usuario.getEmail(), token);

        } catch (UsernameNotFoundException | SenhaInvalidaException ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage());
        }
    }
}
