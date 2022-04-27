package com.example.aula3.controllers;

import com.example.aula3.ApiErrors;
import com.example.aula3.exceptions.RegraNegocioException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {
    @ExceptionHandler(RegraNegocioException.class)
    public ApiErrors handleRegraNegocioException(RegraNegocioException ex) {
        String msg = ex.getMessage();
        return new ApiErrors(msg);
    }
}
