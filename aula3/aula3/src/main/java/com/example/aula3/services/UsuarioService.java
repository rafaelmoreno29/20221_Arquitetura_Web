package com.example.aula3.services;

import com.example.aula3.dto.DadosUsuarioDTO;
import com.example.aula3.dto.UsuarioDTO;
import com.example.aula3.entity.Usuario;

public interface UsuarioService {
    Usuario salvar(UsuarioDTO dto);
    DadosUsuarioDTO obterUsuarioPorId(Integer id);
    void remover(Integer id);
    void editar(Integer id, UsuarioDTO dto);
}
