package com.example.aula3.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import com.example.aula3.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioRepository {
    private static String SELECT_ALL = "select * from tb_usuario";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Usuario inserir(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }

    public List<Usuario> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Usuario>() {
            @Override
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"), 
                        rs.getString("email"),
                        rs.getString("senha")
                    );
            }

        });
    }

}
