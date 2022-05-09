package com.example.aula3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosUsuarioDTO {
    private Integer id;
    private String senha;
    private String email;
    private String nome;
  //  private PerfilDTO perfil;
}
