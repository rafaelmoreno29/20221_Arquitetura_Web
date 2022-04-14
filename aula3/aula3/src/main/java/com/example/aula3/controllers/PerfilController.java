package com.example.aula3.controllers;

import java.util.List;
import java.util.Optional;

import com.example.aula3.entity.Perfil;
import com.example.aula3.repository.PerfilRepository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * PerfilController
 */
@RestController
@RequestMapping(value = "/perfil")
public class PerfilController {

    private PerfilRepository perfilRepository;

    public PerfilController(PerfilRepository perfilRepository){
        this.perfilRepository = perfilRepository;
    }

    @GetMapping("/{id}")    
    public Perfil getById(@PathVariable int id){
        return perfilRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Perfil não encontrado."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Perfil save(@RequestBody Perfil perfil) {
        return perfilRepository.save(perfil);  
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable int id){
        perfilRepository.findById(id)
            .map(perfil -> {
                perfilRepository.delete(perfil);
                return perfil;
            })
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Perfil não encontrado"));        
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update (@PathVariable int id, 
                                        @RequestBody Perfil perfil){
         perfilRepository.findById(id)
                .map(perfilExistente ->{
                    perfil.setId(perfilExistente.getId());
                    perfilRepository.save(perfil);
                    return perfilExistente;
                }) 
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Perfil não encontrado.")); 
    }
    @GetMapping
    public List<Perfil> find(Perfil filtro){
        ExampleMatcher matcher = ExampleMatcher.matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(
                                        StringMatcher.CONTAINING);

        Example example = Example.of(filtro,matcher);
        return perfilRepository.findAll(example);
    }
    
    
    @RequestMapping(value = {"/teste/{nome}","/teste2/{nome}"}, 
                    method = RequestMethod.GET,
                    consumes = {"application/json","application/xml"},
                    produces = {"application/json","application/xml"})
    public String testePerfil(@PathVariable("nome") String nomePerfil){
        return String.format("Olá %s",nomePerfil );
    }
    
}