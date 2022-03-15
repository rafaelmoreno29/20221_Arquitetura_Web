package com.example.exemplo1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Development
public class MinhaConfiguracao {
    @Bean
    public CommandLineRunner executar() {
        return args ->{
            System.out.println("Rodou Dev");
        };
    }


    @Bean(name="appname")
    public String nomeAplicacao() {
        return "Aplicação Exemplo";
    }
    @Bean(name="version")
    public String versaoAplicacao() {
        return "1.0";
    }

    
}
