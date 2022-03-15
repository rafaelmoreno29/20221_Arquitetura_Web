package com.example.exemplo1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @Value("${application.name}")
    private String nome;

    @GetMapping(value="/")
    public String getMethodName() {
        System.out.println(nome);
        return nome;
    }
    
}
