/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
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
@Table(name = "Estudio")
public class Estudio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EstudioID")
    private Long estudioID;
    
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Central")
    private String central;
    
    //relacion 1-1 con Pelicula
    @OneToOne
    @JoinColumn(name = "PeliculaID")
    private Pelicula pelicula;
    
}
