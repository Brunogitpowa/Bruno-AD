/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Pelicula;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author bruno
 */
public class PeliculaDAO {
    
    private final SessionFactory sessionFactory;
    
    
    
    public PeliculaDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void insertarPelicula(Pelicula pelicula) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pelicula);
            transaction.commit();
        }
    }
    
    
    public void actualizarPelicula(Pelicula pelicula) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(pelicula);
            transaction.commit();
        }
    }
    
    
    public void eliminarPelicula(Long peliculaID) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Pelicula pelicula = session.get(Pelicula.class, peliculaID);
            if (pelicula != null) {
                session.delete(pelicula);
            }
            transaction.commit();
        }
    }
    
    
    public Pelicula obtenerPelicula(Long peliculaID) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Pelicula.class, peliculaID);
        }
    }
    
    
    public List<Pelicula> obtenerTodasPeliculas() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Pelicula", Pelicula.class).list();
        }
    }
    
}
