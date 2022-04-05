package com.example.aula3.repository;

import javax.persistence.EntityManager;

import com.example.aula3.entity.Perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PerfilRepository extends JpaRepository<Perfil,Integer> {

    @Query(" select p from Perfil p left join fetch p.usuarios u where p.id = :id ")
    Perfil findPerfilFetchUsuarios(@Param("id") int id);

    Perfil findByNome(String nome);
}
