package ejemplo.xml.dom2;

import org.w3c.dom.*;//Para el paso 1
import javax.xml.parsers.*;//Para el paso 1

import javax.xml.transform.TransformerFactory;//Para el paso 3
import javax.xml.transform.Transformer;//Para el paso 3
import javax.xml.transform.dom.DOMSource;//Para el paso 3
import javax.xml.transform.stream.StreamResult;//Para el paso 3

import javax.xml.transform.OutputKeys;//Para indentar en el paso 3

/**
 *
 * @author noemilm
 */
public class EjemploXMLDOM2 {

    public static void main(String[] args) {
        try{
            // Paso 1: Crear el Documento XML
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=dbf.newDocumentBuilder();
            
            Document registroEmpleados = builder.newDocument(); //Sustitui estÃ¡ linea por las dos siguientes en comentarios
            
            registroEmpleados.setXmlVersion("1.0");
            
            // Paso 2: Crear elementos y agregarlos al documento
            Element elemRaiz = registroEmpleados.createElement("empleado");
            registroEmpleados.appendChild(elemRaiz);
            
            //PARA AÑADIR MÁS DE UNA PERSONA AL ARCHIVO XML
            agregarPersona(registroEmpleados, "Carlos", 30);
            agregarPersona(registroEmpleados, "Roberto", 21);

            
            // Paso 3: Escribir el contenido del documento XML a un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            //XML INDENTADO
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            DOMSource source = new DOMSource(registroEmpleados);
            
            //Especifica la ubicaciÃ³n del archivo de salida
            StreamResult result = new StreamResult("personas.xml");

            // Realiza la transformaciÃ³n y escribe en el archivo
            transformer.transform(source, result);

            System.out.println("Archivo XML creado exitosamente.");
           
        
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private static void agregarPersona(Document registroEmpleados, String nombre, int edad){
        Element elemPersona = registroEmpleados.createElement("persona");
        registroEmpleados.getDocumentElement().appendChild(elemPersona);

        Element elemNombre = registroEmpleados.createElement("nombre");
        elemNombre.appendChild(registroEmpleados.createTextNode(nombre));
        elemPersona.appendChild(elemNombre);

        Element elemEdad = registroEmpleados.createElement("edad");
        elemEdad.appendChild(registroEmpleados.createTextNode(Integer.toString(edad)));
        elemPersona.appendChild(elemEdad);
    }
    
}
