package com.example.aula3.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.aula3.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioRepository {


    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Usuario inserir(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }

    @Transactional
    public Usuario atualizar(Usuario usuario){
        entityManager.merge(usuario);
        return usuario;
    }

    @Transactional
    public void excluir(Usuario usuario){
        if(!entityManager.contains(usuario)){
            usuario = entityManager.merge(usuario);
        }
        entityManager.remove(usuario);
    }

    @Transactional
    public void excluir(int id){
        excluir(entityManager.find(Usuario.class, id));
    }

    @Transactional(readOnly = true)
    public List<Usuario> obterPorNome(String nome){
        String jpql = " select u from Usuario u where u.nome like :nome";
        TypedQuery<Usuario>  query = entityManager.createQuery(jpql,Usuario.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    @Transactional(readOnly = true)
    public List<Usuario> obterTodos() {
        return entityManager.createQuery("from Usuario", Usuario.class).getResultList();
            
    }

}
