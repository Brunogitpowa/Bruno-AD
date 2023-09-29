/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulesxml;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author samuel
 */
public class ModulesXML {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, FileNotFoundException, TransformerException {
        fileXML dom = new fileXML();
        
        /*Llamamos a dos funcion una para leer el fichero xml
        la otra para imprimir por pantalla informacion del DOM
        pasandole como parametros 'read' y 'ruta+fichero.xml'*/
        if (args[0].equalsIgnoreCase("read")) {
            Document doc = dom.OpenXML(args[1]);
            dom.printModules(doc.getDocumentElement());
            
        }
        
        
        /*crearemos en caso de no existir un fichero.xml para
        escribir la informacion incluida en la segunda funcion 
        pasando los parametros 'write' y 'ruta+fichero.xml'*/
        if (args[0].equalsIgnoreCase("write")) {
            File file = new File(args[1]);
            if(!file.exists()) { /*Comprobacion de la existencia del fichero*/
                file.createNewFile();/*creacion del fichero*/
            }
//            Document doc = dom.OpenXML(args[1]);
            dom.writeModules(file);/*Escribimos en el fichero*/
            
        }
    }

}