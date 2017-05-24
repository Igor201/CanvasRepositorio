/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.model.DAO;


import br.edu.model.entidades.Usuario;
import br.edu.model.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Igor Sousa
 */
public class JDBCUsuarioDAO implements DAOGenerico<Usuario> {
    
     private Session session;
    private static JDBCUsuarioDAO instance;

    public JDBCUsuarioDAO() {
       
    }
    
 public static JDBCUsuarioDAO getInstance() {
        if (instance == null) {
            instance = new JDBCUsuarioDAO();
        }
        return instance;
    }
        
 
    @Override
    public void InsertOrUpdate(Object o) {
        session = HibernateUtil.getInstance().Abrirsessao();
        session.beginTransaction();
        try {
            session.saveOrUpdate(o);
        } catch (HibernateException e) {
            System.out.println("Ocorreu um erro na hora de salvar. " + e);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void Delet(int id) {
        session = HibernateUtil.getInstance().Abrirsessao();
        session.beginTransaction();
        Usuario usuario = (Usuario) session.get(Usuario.class, id);
        try {
            session.delete(usuario);
        } catch (IllegalArgumentException ex) {
            System.err.println("Erro: Tentou deletar algo que não existe.");
        }
        session.getTransaction().commit();
    }
    

    @Override
    public void Read(int id) {
        session = HibernateUtil.getInstance().Abrirsessao();
        session.getTransaction().begin();
        try {
            Usuario usuario = (Usuario) session.get(Usuario.class, id);
            System.out.println(usuario.getId()+" "+usuario.getNome()+ " " + usuario.getCpf()+" "+ usuario.getTelefone());
        } catch (NullPointerException ex) {
            System.err.println("Erro: Tentou buscar um codigo inexistente.");
        }
    }

    @Override
    public List ListAll() {
      session = HibernateUtil.getInstance().Abrirsessao();
        session.getTransaction().begin();
        @SuppressWarnings("UnusedAssignment")
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = session.createQuery("from Usuario").list();

        return usuarios;
    }

}

