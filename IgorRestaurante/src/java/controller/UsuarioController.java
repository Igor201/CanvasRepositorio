/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.edu.model.DAO.DAOGenerico;
import br.edu.model.DAO.JDBCUsuarioDAO;
import br.edu.model.entidades.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Igor Sousa
 */
@ManagedBean
@SessionScoped
public class UsuarioController {
    
    private DAOGenerico<Usuario> usuarioAc;
    private Usuario usuario;

    public UsuarioController() {
       usuario = new Usuario();
       this.usuarioAc = JDBCUsuarioDAO.getInstance();
    }

    public void inserirOuAtualizarAction(){
       usuarioAc.InsertOrUpdate(this.usuario);
       usuario = new Usuario();
    }
    public void LerAction(int id){
        usuarioAc.Read(id);
    }
    public void DeletarAction(int id){
        usuarioAc.Delet(id);
    }
    public void ListarTodosAction(){
        usuarioAc.ListAll();
        
    } 

    public Usuario getUsuario() {
        return usuario;
                }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
