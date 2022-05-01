package com.example.aula3.services;

import java.util.ArrayList;
import java.util.List;

import com.example.aula3.dto.DadosUsuarioDTO;
import com.example.aula3.dto.PerfilDTO;
import com.example.aula3.dto.UsuarioDTO;
import com.example.aula3.entity.Perfil;
import com.example.aula3.entity.Usuario;
import com.example.aula3.exceptions.RegraNegocioException;
import com.example.aula3.repository.PerfilRepository;
import com.example.aula3.repository.UsuarioRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;

    @Override
    @Transactional
    public Usuario salvar(UsuarioDTO dto) {
        Perfil perfil = perfilRepository.findById(dto.getPerfil())
                .orElseThrow(() -> new RegraNegocioException("Código do perfil não encontrado."));

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());
        usuario.setSenha(dto.getSenha());
        usuario.setPerfil(perfil);

        return usuarioRepository.save(usuario);
    }

    @Override
    public DadosUsuarioDTO obterUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).map(u -> {
            return DadosUsuarioDTO
                    .builder()
                    .email(u.getEmail())
                    .nome(u.getNome())
                    .perfil(PerfilDTO.builder()
                            .id(u.getPerfil().getId())
                            .nome(u.getPerfil().getNome()).build())
                    .build();
        })
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
    }

    @Override
    @Transactional
    public void remover(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editar(Integer id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
        Perfil perfil = perfilRepository.findById(dto.getPerfil())
                .orElseThrow(() -> new RegraNegocioException("Perfil não existe"));

        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());
        usuario.setSenha(dto.getSenha());
        usuario.setPerfil(perfil);

        usuarioRepository.save(usuario);

    }

    @Override
    public ArrayList<DadosUsuarioDTO> obterUsuarios() {
        ArrayList<DadosUsuarioDTO> dados = new ArrayList<>();

        List<Usuario> usuarios = usuarioRepository.findAll();
        usuarios.forEach(u -> {
            dados.add(
                    DadosUsuarioDTO
                            .builder()
                            .email(u.getEmail())
                            .nome(u.getNome())
                            .perfil(PerfilDTO.builder()
                                    .id(u.getPerfil().getId())
                                    .nome(u.getPerfil().getNome()).build())
                            .build());
        });
        return dados;
    }
}
