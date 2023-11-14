package ejercicio3.xmldom;

/**
 *
 * @author noemilm
 */

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;


public class Ejercicio3XMLDOM {
       
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("estudiantes.xml");
            
            //Eliminar líneas en blanco del XML
            removeWhitespace(document);

            Scanner scanner = new Scanner(System.in);

            // Mostrar información de estudiantes existentes
            System.out.println("Estudiantes existentes:");
            NodeList estudiantes = document.getElementsByTagName("estudiante");
            for (int i = 0; i < estudiantes.getLength(); i++) {
                Element estudiante = (Element) estudiantes.item(i);
                String id = estudiante.getElementsByTagName("id").item(0).getTextContent();
                String nombre = estudiante.getElementsByTagName("nombre").item(0).getTextContent();
                String edad = estudiante.getElementsByTagName("edad").item(0).getTextContent();
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
            }

            // Agregar un nuevo estudiante
            Element nuevoEstudiante = document.createElement("estudiante");
            Element nuevoId = document.createElement("id");
            Element nuevoNombre = document.createElement("nombre");
            Element nuevaEdad = document.createElement("edad");

            System.out.print("Ingrese el ID del nuevo estudiante: ");
            nuevoId.setTextContent(scanner.nextLine());

            System.out.print("Ingrese el nombre del nuevo estudiante: ");
            nuevoNombre.setTextContent(scanner.nextLine());

            System.out.print("Ingrese la edad del nuevo estudiante: ");
            nuevaEdad.setTextContent(scanner.nextLine());

            nuevoEstudiante.appendChild(nuevoId);
            nuevoEstudiante.appendChild(nuevoNombre);
            nuevoEstudiante.appendChild(nuevaEdad);

            Element root = document.getDocumentElement();
            root.appendChild(nuevoEstudiante);
              
            // Guardar los cambios en el archivo XML
            FileOutputStream output = new FileOutputStream(new File("estudiantes.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            //Codificacion UTF 8
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new javax.xml.transform.dom.DOMSource(document), new javax.xml.transform.stream.StreamResult(output));
            output.close();

            System.out.println("Nuevo estudiante agregado y cambios guardados en el archivo XML."); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //MÉTODO PARA ELIMINAR LÍNEAS EN BLANCO DEL XML
    public static void removeWhitespace(Document document) {
        Set<Node> toRemove = new HashSet<Node>();
        DocumentTraversal t = (DocumentTraversal) document;
        NodeIterator it = t.createNodeIterator(document,
                NodeFilter.SHOW_TEXT, null, true);

        for (Node n = it.nextNode(); n != null; n = it.nextNode()) {
            if (n.getNodeValue().trim().isEmpty()) {
                toRemove.add(n);
            }
        }

        for (Node n : toRemove) {
            n.getParentNode().removeChild(n);
        }
    }
}
