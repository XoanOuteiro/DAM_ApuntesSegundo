package ejercicio2xmldom;

/**
 *
 * @author noemilm
 */

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ejercicio2XMLDOM {
    public static void main(String[] args) {
        try {
            // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Crear un DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Analizar el archivo XML
            Document document = builder.parse("libros2.xml");

            // Obtener la lista de nodos de libros
            NodeList libros = document.getElementsByTagName("libro");

            double totalPrecio = 0;
            int numLibros = libros.getLength();

            // Iterar a través de los nodos de libros
            for (int i = 0; i < numLibros; i++) {
                Element libro = (Element) libros.item(i);
                double precio = Double.parseDouble(libro.getElementsByTagName("precio").item(0).getTextContent());
                totalPrecio += precio;
            }

            double precioPromedio = totalPrecio / numLibros;
            System.out.println("Precio promedio de los libros: $" + precioPromedio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
