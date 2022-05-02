package com.example.aula3.controllers;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;

import com.example.aula3.ApiErrors;
import com.example.aula3.exceptions.RegraNegocioException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RegraNegocioException.class)
    public ApiErrors handlerRegraNegocioException(RegraNegocioException ex)
    {
        String msg = ex.getMessage();
        return new ApiErrors(msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handlerMethodValidException(MethodArgumentNotValidException ex){
        String msg = ex.getMessage();
        return new ApiErrors(msg);
    }
    

    
}
