/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ORM;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author bruno
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    
    static{
        try{
            sessionFactory = new Configuration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();
            
        } catch (Throwable ex) {
            System.err.println("Error en la inicializacion. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
