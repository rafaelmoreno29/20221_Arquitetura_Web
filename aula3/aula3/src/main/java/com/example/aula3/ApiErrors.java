package com.example.aula3;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

/**
 * ApiErrors
 */
public class ApiErrors {
    @Getter
    private List<String> errors;
    
    public ApiErrors(String mensagem){
        this.errors = Arrays.asList(mensagem);
    }    
}