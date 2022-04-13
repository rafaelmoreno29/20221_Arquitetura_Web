package com.example.aula3.controllers;

import java.util.Optional;

import com.example.aula3.entity.Perfil;
import com.example.aula3.repository.PerfilRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * PerfilController
 */
@Controller
@RequestMapping(value = "/perfil")
public class PerfilController {

    private PerfilRepository perfilRepository;

    public PerfilController(PerfilRepository perfilRepository){
        this.perfilRepository = perfilRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Perfil> getById(@PathVariable int id){
        Optional<Perfil> perfil = perfilRepository.findById(id);
        if(perfil.isPresent())
            return ResponseEntity.ok(perfil.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Perfil> save(@RequestBody Perfil perfil) {
        Perfil perfilSalvo = perfilRepository.save(perfil);        
        return ResponseEntity.ok(perfilSalvo);
    }
    
    
    @RequestMapping(value = {"/teste/{nome}","/teste2/{nome}"}, 
                    method = RequestMethod.GET,
                    consumes = {"application/json","application/xml"},
                    produces = {"application/json","application/xml"})
    @ResponseBody
    public String testePerfil(@PathVariable("nome") String nomePerfil){
        return String.format("Olá %s",nomePerfil );
    }
    
}