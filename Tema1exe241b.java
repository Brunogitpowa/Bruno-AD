/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema1exe241b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author bruno
 */
public class Tema1exe241b {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
            BufferedReader fin;
            PrintWriter fout;
            
            
            //int num_linia;
            String linia;
            
            /*comprobacion de argumentos*/
            if (args.length != 2) {
                System.out.println("Error. Argumentos");
                return;
            }
            
            fin = new BufferedReader(new FileReader(args[0]));
            fout = new PrintWriter(new FileWriter(args[1]));
            
            
            //num_linia = 1;
            
            
            do{
                /*leemos linea a linea*/
                linia = fin.readLine();
                if (linia != null){
                    
                    /*Metodo indexOf devuelve el indice que corresponde
                    al caracter pasado en el objeto String desde donde se le llama*/
                    int indice = linia.indexOf('.');
                    
                    /*Comprovamos que existe el caracter pasado*/
                    if (indice != -1) {
                        
                        /*Metodo substring devuelve el string
                        apartir del indice al que sumamos 1 para evitar
                        el caracter*/
                        String afterPoint = linia.substring(indice + 1);
                        
                        /*Copiamos en el fichero de Escritura evitando la numeracion
                        de las lineas y el punto*/
                        fout.println(afterPoint);
                        
                    }
                 
                }
                //num_linia++;
                
            } while (linia != null);
            
            fin.close();
            fout.close();
            
       
    }
    
}
