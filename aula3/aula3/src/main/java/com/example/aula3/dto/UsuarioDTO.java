package com.example.aula3.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;
    @NotEmpty(message = "Senha é obrigatório")
    private String senha;
    @NotNull(message = "Perfil é obrigatório")
    private Integer perfil;
}
