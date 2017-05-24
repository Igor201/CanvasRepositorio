/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.model;

import br.edu.model.entidades.Pedido;
import br.edu.model.DAO.DAOGenerico;
import java.util.List;

/**
 *
 * @author Igor Sousa
 */
public class PedidoModel implements DAOGenerico<Pedido> {

    @Override
    public void InsertOrUpdate(Object o) {
        
    }

    @Override
    public void Delet(int num_pedido) {
       
    }

    @Override
    public void Read(int num_pedido) {
    
    }

    @Override
    public List ListAll() {
        return null;
    }
    
}
