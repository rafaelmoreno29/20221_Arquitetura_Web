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
    @NotEmpty(message = "E-mail é obrigatório")
    @Email(message = "E-mail não é válido")
    private String email;
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;
    @NotEmpty(message = "Senha é obrigatório")
    private String senha;
    @NotNull(message = "Perfil é obrigatório")
    private Integer perfil;
   // @CPF(message = "CPF inválido")
   // private String cpf;
}
