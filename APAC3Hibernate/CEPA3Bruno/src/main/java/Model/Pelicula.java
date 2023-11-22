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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "Pelicula")
public class Pelicula implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PeliculaID")
    private Long peliculaID;
    
    
    @Column(name = "Titulo")
    private String titulo;
    
    
    @Column(name = "Estreno")
    private int estreno;
    
    
    @Column(name = "Presupuesto")
    private int presupuesto;
    
    
    //relacion N-1 con director
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DirectorID")
    private Director director;
    
    
    //relacion N-M con Actor
    @ManyToMany
    @JoinTable(
            name = "ActorPelicula",
            joinColumns = @JoinColumn(name = "PeliculaID"),
            inverseJoinColumns = @JoinColumn(name = "ActorID")
    )
    private Set<Actor> actores = new HashSet<>();
    
    
    //relacion 1-1 con Estudio
    @OneToOne(mappedBy = "pelicula", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Estudio estudio;
    
}
