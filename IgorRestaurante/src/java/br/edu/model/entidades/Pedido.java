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
public class Pedido implements Serializable {
    
    @Id 
    @GeneratedValue
    private int num_pedido;
    @Column (length=20, unique=true)
    private String hora_pedido;
    @Column
    private int mesa;

    public Pedido(int num_pedido, String hora_pedido, int mesa) {
        this.num_pedido = num_pedido;
        this.hora_pedido = hora_pedido;
        this.mesa = mesa;
    }

    public Pedido() {
    }

    public void setNum_pedido(int num_pedido) {
        this.num_pedido = num_pedido;
    }

    public void setHora_pedido(String hora_pedido) {
        this.hora_pedido = hora_pedido;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getNum_pedido() {
        return num_pedido;
    }

    public String getHora_pedido() {
        return hora_pedido;
    }

    public int getMesa() {
        return mesa;
    }
}
