/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.model.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Igor Sousa
 */
public class HibernateUtil {
    
    private static SessionFactory sessionF = null;
    private static HibernateUtil instance=null;


    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    public static SessionFactory getFactoryConfig() {
        if (sessionF == null) {
            sessionF = new Configuration().configure().buildSessionFactory();
            
            
        }
        return sessionF;
    }

    public static Session Abrirsessao() {
        
        Session session = getFactoryConfig().openSession();
        return session;
        
        
        /*if (session != null && !session.isOpen()) {
            session = null;
        }

        session = getFactoryConfig().openSession();

        return session;*/
    }
}
