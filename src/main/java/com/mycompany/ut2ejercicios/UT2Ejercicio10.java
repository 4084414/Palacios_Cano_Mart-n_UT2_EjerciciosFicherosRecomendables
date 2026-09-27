/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ut2ejercicios;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author maste
 */
public class UT2Ejercicio10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
            // 1. Instanciamos la factoría y el constructor de documentos DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // 2. Creamos un XML vacío
            Document doc = builder.newDocument();
            
            
            //System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
            
            // 3. Creamos el elemento raíz intituto
            Element instituto = doc.createElement("instituto");
            doc.appendChild(instituto);
            
            // 4. Creamos el elemento modulo
            Element modulo = doc.createElement("modulo");
            // Añadimos el atributo codigo al elemento modulo
            modulo.setAttribute("codigo", "DAM");
            // Añadimos el texto a modulo
            modulo.setTextContent("Acceso a Datos");
            // Añadimos <modulo> dentro de <instituto>
            instituto.appendChild(modulo);
            
            
            // Opcional: Normaliza la estructura del árbol de nodos
            doc.getDocumentElement().normalize();
            
            // 5. Creamos el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            
            // 6. Guardamos el documento XML
            // Indicamos el archivo de destino
            StreamResult resultado = new StreamResult(new File("instituto.xml"));
            // Indicamos el documento DOM como fuente
            DOMSource fuente = new DOMSource(doc);
            //Guardo
            transformer.transform(fuente, resultado);

            System.out.println("Xml creado correctamente");
            
            
        } catch (Exception e) {
            System.err.println("Error al a saber: " + e.getMessage());
        }
    }
    
}
