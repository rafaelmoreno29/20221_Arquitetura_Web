package com.example.aula3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_produto;
    @Column(name = "prod_nome")
    private String nome;
    @Column(name = "prod_qtd")
    private Integer quantidade;
    @ManyToOne()
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    public Produto(Integer id_produto, String nome, Integer quantidade, Categoria categoria) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }
    public Produto() {
    }
    public Integer getId_produto() {
        return id_produto;
    }
    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
