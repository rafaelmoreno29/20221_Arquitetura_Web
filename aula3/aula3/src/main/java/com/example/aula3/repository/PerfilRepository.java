package com.example.aula3.repository;

import javax.persistence.EntityManager;

import com.example.aula3.entity.Perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PerfilRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Perfil inserir(Perfil perfil){
        entityManager.persist(perfil);
        return perfil;
    }
}
