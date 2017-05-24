/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.edu.model.DAO.DAOGenerico;
import br.edu.model.DAO.JDBCPedidoDAO;
import br.edu.model.entidades.Pedido;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Igor Sousa
 */
    
@ManagedBean
@SessionScoped
public class PedidoController {
    
    
    private DAOGenerico<Pedido> pedidoAc;
    private Pedido pedido;

    public PedidoController() {
       pedido = new Pedido();
       this.pedidoAc = JDBCPedidoDAO.getInstance();
    }

    public void inserirOuAtualizarAction(){
       pedidoAc.InsertOrUpdate(this.pedido);
       pedido = new Pedido();
    }
    public void LerAction(int num_pedido){
        pedidoAc.Read(num_pedido);
    }
    public void DeletarAction(int num_pedido){
        pedidoAc.Delet(num_pedido);
    }
    public List ListarTodosAction(){
      return pedidoAc.ListAll();
        
    }

    public Pedido getPedido() {
        return pedido;
                }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public DAOGenerico<Pedido> getPedidoAc() {
        return pedidoAc;
    }

    public void setPedidoAc(DAOGenerico<Pedido> pedidoAc) {
        this.pedidoAc = pedidoAc;
    }
    
    
    
}

