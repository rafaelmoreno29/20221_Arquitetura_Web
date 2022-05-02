package com.example.aula3.dto;

import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "E-mail é obrigatório")
    private String email;
    private String nome;
    private String senha;
    private Integer perfil;
}
