package com.example.aula3.services;

import java.util.ArrayList;

import com.example.aula3.dto.DadosUsuarioDTO;
import com.example.aula3.dto.UsuarioDTO;
import com.example.aula3.entity.Usuario;

import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioService {
    Usuario salvar(UsuarioDTO dto);
    DadosUsuarioDTO obterUsuarioPorId(Integer id);
    void remover(Integer id);
    void editar(Integer id, UsuarioDTO dto);
    ArrayList<DadosUsuarioDTO> obterUsuarios();
    UserDetails autenticar(Usuario usuario);
}
