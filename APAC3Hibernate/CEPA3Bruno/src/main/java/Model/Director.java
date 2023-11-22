/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author bruno
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Director")
public class Director implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DirectorID")
    private Long directorID;
    
    
    @Column(name = "Nombre")
    private String nombre;
    
    
    @Column(name = "Edad")
    private int edad;
    
    
    //relacion 1-M con Pelicula
    @OneToMany(mappedBy = "director", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Pelicula> peliculasDirigidas = new HashSet<>();
    
}
