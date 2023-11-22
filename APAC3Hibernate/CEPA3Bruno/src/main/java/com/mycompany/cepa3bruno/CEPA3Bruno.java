/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cepa3bruno;


import DAO.PeliculaDAO;
import Model.Actor;
import Model.Director;
import Model.Estudio;
import Model.Pelicula;
import ORM.HibernateUtil;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author bruno
 */
public class CEPA3Bruno {
    
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        
        
        while(true){
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    menuPelicula();
                    int op = scanner.nextInt();
                    scanner.nextLine();
                    switch (op) {
                        case 1:
                            Pelicula p = new Pelicula();
                            PeliculaDAO pDAO = new PeliculaDAO(sessionFactory);
                            System.out.println("Titulo de la Pelicula: ");
                            String nombre = scanner.nextLine();
                            System.out.println("Año de estreno: ");
                            int anio = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Presupuesto de la pelicula: ");
                            int presu = scanner.nextInt();
                            scanner.nextLine();
                            p.setTitulo(nombre);
                            p.setPresupuesto(presu);
                            p.setEstreno(anio);
                            pDAO.insertarPelicula(p);
                            break;
                            
                        case 2:
                            PeliculaDAO pEliminar = new PeliculaDAO(sessionFactory);
                            System.out.println("Id de la Pelicula a eliminar: ");
                            long idEliminar = scanner.nextLong();
                            scanner.nextLine();
                            pEliminar.eliminarPelicula(idEliminar);
                            break;
                            
                        case 3:
                            PeliculaDAO pActualizar = new PeliculaDAO(sessionFactory);
                            System.out.println(pActualizar.obtenerTodasPeliculas());
                            System.out.println("ID de la Pelicula a modificar: ");
                            long idActualizar = scanner.nextLong();
                            scanner.nextLine();
                            System.out.println("Dato a actualizar");
                            System.out.println("1.- Estreno");
                            System.out.println("2.- Presupuesto");
                            System.out.println("3.- Titulo");
                            int datoActualizar = scanner.nextInt();
                            scanner.nextLine();
                            switch (datoActualizar) {
                                case 1:
                                    Pelicula peliEstreno;
                                    System.out.println("Ingresa el año del Estreno: ");
                                    int estreno = scanner.nextInt();
                                    scanner.nextLine();
                                    peliEstreno = pActualizar.obtenerPelicula(idActualizar);
                                    peliEstreno.setEstreno(estreno);
                                    pActualizar.actualizarPelicula(peliEstreno);
                                    break;
                                
                                case 2:
                                    Pelicula peliPresupuesto;
                                    System.out.println("Ingresa el Presupuesto: ");
                                    int presupuesto = scanner.nextInt();
                                    scanner.nextLine();
                                    peliPresupuesto = pActualizar.obtenerPelicula(idActualizar);
                                    peliPresupuesto.setPresupuesto(presupuesto);
                                    pActualizar.actualizarPelicula(peliPresupuesto);
                                    break;
                                
                                case 3:
                                    Pelicula peliTitulo;
                                    System.out.println("Ingresa Titulo: ");
                                    String titulo = scanner.nextLine();
                                    peliTitulo = pActualizar.obtenerPelicula(idActualizar);
                                    peliTitulo.setTitulo(titulo);
                                    pActualizar.actualizarPelicula(peliTitulo);
                                    break;
                                
                                
                            }
                            break;
                            
                        case 4:
                            PeliculaDAO pListaPeliculas = new PeliculaDAO(sessionFactory);
                            List<Pelicula> peliculas = pListaPeliculas.obtenerTodasPeliculas();
                            System.out.println("\nLISTA PELICULAS");
                            for (Pelicula pelicula : peliculas) {
                                System.out.println(pelicula.getTitulo());
                            }
                            break;
                            
                        case 5:
                            break;
                            
                                
                    }       
                    break;
                    
                case 2:
                    menuDirector();
                    break;
                case 3:
                    menuActor();
                    break;
                case 4:
                    menuEstudio();
            }
        }
            
        
        
        
        
    }
    
    public static void mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("////// MENU //////");
        System.out.println("1.- Pelicula");
        System.out.println("2.- Director");
        System.out.println("3.- Actor");
        System.out.println("4.- Estudio");
        System.out.println("5.- Salir");
        
    }
    
    public static void menuPelicula(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.- Insertar pelicula");
        System.out.println("2.- Eliminar pelicula");
        System.out.println("3.- Actualizar pelicula");
        System.out.println("4.- Consultar lista de peliculas");
        System.out.println("5.- Atras");
    }
    
    public static void menuDirector(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.- Insertar director");
        System.out.println("2.- Eliminar director");
        System.out.println("3.- Actualizar director");
        System.out.println("4.- Consultar lista de directores");
        System.out.println("5.- Atras");
    }
    
    public static void menuActor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.- Insertar actor");
        System.out.println("2.- Eliminar actor");
        System.out.println("3.- Actualizar actor");
        System.out.println("4.- Consultar lista de actores");
        System.out.println("5.- Atras");
    }
    
    public static void menuEstudio(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.- Insertar estudio");
        System.out.println("2.- Eliminar estudio");
        System.out.println("3.- Actualizar estudio");
        System.out.println("4.- Consultar lista de estudios");
        System.out.println("5.- Atras");
    }
     
}
