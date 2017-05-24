/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.model.DAO;

import br.edu.model.entidades.Pedido;
import br.edu.model.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;



/**
 *
 * @author Igor Sousa
 */

    
public class JDBCPedidoDAO implements DAOGenerico<Pedido>{
    
    private Session session;
    private static JDBCPedidoDAO instance;

    public JDBCPedidoDAO() {
       
    }
    
 public static JDBCPedidoDAO getInstance() {
        if (instance == null) {
            instance = new JDBCPedidoDAO();
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
    public void Delet(int num_pedido) {
        session = HibernateUtil.getInstance().Abrirsessao();
        session.beginTransaction();
        Pedido pedido = (Pedido) session.get(Pedido.class, num_pedido);
        try {
            session.delete(pedido);
        } catch (IllegalArgumentException ex) {
            System.err.println("Erro: Tentou deletar algo que não existe.");
        }
        session.getTransaction().commit();
    }
    

    @Override
    public void Read(int num_pedido) {
        session = HibernateUtil.getInstance().Abrirsessao();
        session.getTransaction().begin();
        try {
            Pedido pedido = (Pedido) session.get(Pedido.class, num_pedido);
            System.out.println(pedido.getNum_pedido()+ " " + pedido.getHora_pedido());
        } catch (NullPointerException ex) {
            System.err.println("Erro: Tentou buscar um codigo inexistente.");
        }
    }

    @Override
    public List ListAll() {
      session = HibernateUtil.getInstance().Abrirsessao();
        session.getTransaction().begin();
        @SuppressWarnings("UnusedAssignment")
        List<Pedido> pedidos = new ArrayList<>();
        pedidos = session.createQuery("from Pedido").list();

    return pedidos;
        
    }

}

