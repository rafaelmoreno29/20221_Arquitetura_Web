package com.example.aula3.entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    @OneToMany(mappedBy = "perfil")
    private List<Usuario> usuarios;

    public Perfil(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Perfil() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Id: " + id + " nome: " + nome;
    }

    
}
