package com.example.aula3.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.aula3.entity.Perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface PerfilRepository extends JpaRepository<Perfil,Integer>{
    
    @Query("select p from Perfil p left join fetch p.usuarios where p.id = :id")
    List<Perfil> findPerfilByIdFetchUsuarios(@Param("id") int id);

   // @Query(value =  "select count(*) from tb_usuario where perfil_id = :id", nativeQuery = true)
   // Integer countUsuario(@Param("id") int id);

    @Query(value =  "select count(u) from Usuario u where u.perfil = :p")
    Integer countUsuario(@Param("p") Perfil p);

    Integer countById(@Param("id") int id);
}
