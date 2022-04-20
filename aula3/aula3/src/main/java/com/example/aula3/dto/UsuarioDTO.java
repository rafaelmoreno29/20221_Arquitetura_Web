package com.example.aula3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String email;
    private String nome;
    private String senha;
    private Integer perfil;
}
