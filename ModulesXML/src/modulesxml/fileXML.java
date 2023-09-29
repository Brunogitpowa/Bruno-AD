/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulesxml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author bruno
 */
public class fileXML {
    
    
    
    /*Abrimos un fichero .XML*/
    public Document OpenXML(String name) throws IOException, SAXException, ParserConfigurationException, FileNotFoundException {

        // Create an instance of DocumentBuilderFactory
        /*1 BuilderFactory
          2 Builder
          3 DOM
        Abrimos un fichero en modo DOM*/
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document dom = null;
       
        try {
//            File newfile = new File(name);
            dom = dBuilder.parse(name);

        } catch (IOException e) {

        }
        
        return dom; /*Devolvemos el Document Object Model DOM*/
    }

    
    
    
    /*Esta funcion sirve para mostrar 
    el contenido de cada elemento*/
    public void printModules(Element root) { 
        
        /*Instanciamos un objeto NodeList para iterar los nodos del Elemento raiz*/
        NodeList modules = root.getElementsByTagName("modul");
        
        /*Recorremos la lista de nodos y mostramos todos los datos de todos los modulos*/
        for (int i = 0; i < modules.getLength(); i++) {
            Element e = (Element) modules.item(i);
            
            
            System.out.println(e.getNodeName() + " " + (i + 1));

            System.out.println("Nom: " + e.getElementsByTagName("nom").item(0).getFirstChild().getNodeValue());
            System.out.println("Hores: " + e.getElementsByTagName("hores").item(0).getFirstChild().getNodeValue());
            System.out.println("Qualificació: " + e.getElementsByTagName("qualificacio").item(0).getFirstChild().getNodeValue());
//            System.out.println("Time: " + e.getElementsByTagName("time").item(0).getFirstChild().getNodeValue());
        }
    }

    
    /*creamos un fichero.xml*/
    public void writeModules(File file) throws SAXException, ParserConfigurationException,
            TransformerConfigurationException, FileNotFoundException, TransformerException {
        
        /**Instanciamos un documento 
        con el modelo DOM**/
        
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        
        // root elements
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
       
        try {
            /*Comenzamos a insertar informacion*/
            Element rootElement = doc.createElement("course");/*Elemento raiz*/
            doc.appendChild(rootElement);

            Element module = doc.createElement("module");/*Creamos el elemento module*/

            /*Creamos los elemmentos name,hours,time*/    
            Element name = doc.createElement("name");
            Element hours = doc.createElement("hours");
            Element currentTime = doc.createElement("time");
            
            /*Incluimos el de Student*/
            Element student = doc.createElement("student");
            
            /*Añadimos los datos que portaran los elementos*/
            name.appendChild(doc.createTextNode("Accés a dades"));
            hours.appendChild(doc.createTextNode(Integer.toString(8)));/*En caso de ser int se incluye en modo String*/
            
            /*texto student*/
            student.appendChild(doc.createTextNode("Bruno Rodriguez Soria"));/*añadimos el texto */
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");/*Una clase que nos da datos sobre fecha y hora*/
            LocalDateTime now = LocalDateTime.now(); /*con la funcion now conseguimos la hora de ya*/  
            currentTime.appendChild(doc.createTextNode(now.toString()));

            /*Despues de incluir los datos toca incluir de la misma manera al root 
            los elementos creados arriba*/
            module.appendChild(name); 
            module.appendChild(hours); 
            module.appendChild(currentTime);
            module.appendChild(student);

            rootElement.appendChild(module);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        /*El metodo Transformer pasa la informacion entre el dom que 
        le pasamos en la variable source y el fichero que pasamos como
        parametro en la funcion file*/
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream(file));
        trans.transform(source, result);

    }

}
    

