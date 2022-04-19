package com.example.aula3.exceptions;

public class RegraNegocioException extends RuntimeException {
    public RegraNegocioException(String mensagem){
        super(mensagem);
    }
}
