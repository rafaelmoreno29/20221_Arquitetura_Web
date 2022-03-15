package com.example.exemplo1.Services;

import com.example.exemplo1.Models.Usuario;
import com.example.exemplo1.Repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public void inserir(Usuario usuario){

    }
    public boolean validar(Usuario usuario){
        return true;
    }
}