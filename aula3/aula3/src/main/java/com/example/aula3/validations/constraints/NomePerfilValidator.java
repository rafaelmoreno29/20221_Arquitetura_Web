package com.example.aula3.validations.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.aula3.validations.NomePerfil;

public class NomePerfilValidator implements 
                                ConstraintValidator<NomePerfil, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            if(value.matches("[a-z]{6}[0-9]{2}"))
                return true;
            else
                return false;
        } catch (Exception ex) {
            return false;
        }
    }

  
}
