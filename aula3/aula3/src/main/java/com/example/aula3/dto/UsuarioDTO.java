package com.example.aula3.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

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
    @NotEmpty(message = "{campo.email-usuario.obrigatorio}")
    @Email(message = "{campo.email-usuario.invalido}")
    private String email;
    @NotEmpty(message = "{campo.nome-usuario.obrigatorio}")
    private String nome;
    @NotEmpty(message = "{campo.senha-usuario.obrigatorio}")
    private String senha;
    @NotNull(message = "{campo.perfil-usuario.obrigatorio}")
    private Integer perfil;   
}
