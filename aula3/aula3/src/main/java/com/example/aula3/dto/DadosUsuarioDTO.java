package com.example.aula3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosUsuarioDTO {
    private String email;
    private String nome;
    private PerfilDTO perfil;
}
