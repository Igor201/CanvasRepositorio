/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.edu.model.DAO.DAOGenerico;
import br.edu.model.DAO.JDBCPedidoDAO;
import br.edu.model.DAO.JDBCProdutoDAO;
import br.edu.model.entidades.Produto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Igor Sousa
 */
@ManagedBean
@SessionScoped
public class ProdutoController {
    
    private DAOGenerico<Produto> produtoAc;
    private Produto produto;

    public ProdutoController() {
       produto = new Produto();
       this.produtoAc = JDBCProdutoDAO.getInstance();
    }

    public void inserirOuAtualizarAction(){
       produtoAc.InsertOrUpdate(this.produto);
       produto = new Produto();
    }
    public void LerAction(int id){
        produtoAc.Read(id);
    }
    public void DeletarAction(int id){
        produtoAc.Delet(id);
    }
    public void ListarTodosAction(){
        produtoAc.ListAll();
        
    } 

    public DAOGenerico<Produto> getProdutoAc() {
        return produtoAc;
    }

    public Produto getProduto() {
        return produto;
    }

    
    
    public void setProdutoAc(DAOGenerico<Produto> produtoAc) {
        this.produtoAc = produtoAc;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
}
