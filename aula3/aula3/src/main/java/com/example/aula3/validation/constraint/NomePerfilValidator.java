package com.example.aula3.validation.constraint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.aula3.validation.NomePerfil;

public class NomePerfilValidator implements ConstraintValidator<NomePerfil, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    
        try {
            if (!value.matches("[a-z]{6}[0-9]{2}")) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
