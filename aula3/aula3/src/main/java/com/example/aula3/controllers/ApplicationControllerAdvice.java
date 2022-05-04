package com.example.aula3.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.aula3.ApiErrors;
import com.example.aula3.exceptions.RegraNegocioException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {
    @ExceptionHandler(RegraNegocioException.class)
    public ApiErrors handlerRegraNegocioException(RegraNegocioException ex)
    {
        String msg = ex.getMessage();
        return new ApiErrors(msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handlerMethodArgumentNotValidException(
                                MethodArgumentNotValidException ex){
        List<String> erros = ex.getBindingResult().getAllErrors()
                                .stream()
                                .map(erro -> erro.getDefaultMessage())
                                .collect(Collectors.toList());
        return new ApiErrors(erros);
                                
     }
}
