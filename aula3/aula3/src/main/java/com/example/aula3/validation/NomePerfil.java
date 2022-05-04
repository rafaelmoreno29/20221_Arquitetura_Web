package com.example.aula3.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.aula3.validation.constraint.NomePerfilValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NomePerfilValidator.class )
public @interface NomePerfil {
    String message() default "Nome fora do padrão";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
}
