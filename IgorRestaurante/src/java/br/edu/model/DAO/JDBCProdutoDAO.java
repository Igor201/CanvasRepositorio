/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.model.DAO;

import br.edu.model.entidades.Produto;
import br.edu.model.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Igor Sousa
 */
public class JDBCProdutoDAO implements DAOGenerico<Produto> {
    
    private Session session;
    private static JDBCProdutoDAO instance;

    public JDBCProdutoDAO() {
       
    }
    
 public static JDBCProdutoDAO getInstance() {
        if (instance == null) {
            instance = new JDBCProdutoDAO();
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
        Produto produto = (Produto) session.get(Produto.class, id);
        try {
            session.delete(produto);
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
            Produto produto = (Produto) session.get(Produto.class, id);
            System.out.println(produto.getId_produto()+" "+ produto.getNome_produto()+" "+produto.getTipo_produto()+" "
                    +produto.getValor_produto()+" "+produto.getDescricao());
        } catch (NullPointerException ex) {
            System.err.println("Erro: Tentou buscar um codigo inexistente.");
        }
    }

    @Override
    public List ListAll() {
      session = HibernateUtil.getInstance().Abrirsessao();
        session.getTransaction().begin();
        @SuppressWarnings("UnusedAssignment")
        List<Produto> produtos = new ArrayList<>();
        produtos = session.createQuery("from Produto").list();
        return produtos;
    }

}
