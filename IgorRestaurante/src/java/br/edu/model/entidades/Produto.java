/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.model.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Igor Sousa
 */
@Entity
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue
    private int id_produto;
    @Column (length=100)
    private String descricao;
    @Column (length=20)
    private String nome_produto;
    @Column (length=8)
    private String tipo_produto;
    @Column 
    private double valor_produto;

    public Produto(int id_alimento, String descricao, String nome_produto, String tipo_produto, double valor_produto) {
        this.id_produto = id_produto;
        this.descricao = descricao;
        this.nome_produto = nome_produto;
        this.tipo_produto = tipo_produto;
        this.valor_produto = valor_produto;
    }

    public Produto (){
        
    }
    
    
    public int getId_produto() {
        return id_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public String getTipo_produto() {
        return tipo_produto;
    }

    public double getValor_produto() {
        return valor_produto;
    }
    
    

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public void setTipo_produto(String tipo_produto) {
        this.tipo_produto = tipo_produto;
    }

    public void setValor_produto(double valor_produto) {
        this.valor_produto = valor_produto;
    }

    
}
