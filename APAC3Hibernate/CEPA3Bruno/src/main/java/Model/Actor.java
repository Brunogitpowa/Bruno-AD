/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author bruno
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Actor")
public class Actor implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ActorID")
    private Long actorID;
    
    
    @Column(name = "Nombre")
    private String nombre;
    
    
    @Column(name = "Edad")
    private int edad;
    
    
    //relacion N-M con Pelicula
    @ManyToMany(mappedBy = "actores")
    private Set<Pelicula> peliculas = new HashSet<>();
    
    
}
