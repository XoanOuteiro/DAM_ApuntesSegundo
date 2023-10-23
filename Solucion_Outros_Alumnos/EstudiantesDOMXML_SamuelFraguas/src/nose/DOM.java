/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nose;

import java.io.File;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author a22samuelfn
 */
public class DOM {

    private Document docu;
    private NodeList estudiantes;

    public DOM(Document docu) {
        docu.getDocumentElement().normalize();
        this.docu = docu;
        estudiantes = this.docu.getElementsByTagName("estudiante");
    }

    public void añadirEstudiante(String nombre, String edad) {

        Node est = estudiantes.item(estudiantes.getLength() - 1);
        Element estud = (Element) est;
        String lastID = estud.getElementsByTagName("id").item(0).getTextContent();

        Element estudiante = docu.createElement("estudiante");
        docu.getDocumentElement().appendChild(estudiante);

        Element id = docu.createElement("id");
        int tmp = Integer.parseInt(lastID);
        tmp++;
        lastID = "" + tmp;
        Text texto = docu.createTextNode(lastID);
        id.appendChild(texto);
        estudiante.appendChild(id);

        Element nom = docu.createElement("nombre");
        texto = docu.createTextNode(nombre);
        nom.appendChild(texto);
        estudiante.appendChild(nom);

        Element ed = docu.createElement("edad");
        texto = docu.createTextNode(edad);
        ed.appendChild(texto);
        estudiante.appendChild(ed);
    }

    public void escribir() {
        try {
            Source origen = new DOMSource(docu);
            Result result = new StreamResult(new File("Estudiantes2.xml"));
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            removeWhitespaces(docu.getDocumentElement());
            trans.transform(origen, result);
        } catch (TransformerException ex) {
            System.out.print("Nada falla");
            System.exit(0);
        }
    }

    private void removeWhitespaces(Element element) {
        NodeList children = element.getChildNodes();
        for (int i = children.getLength() - 1; i >= 0; i--) {
            Node child = children.item(i);
            if (child instanceof Text
                    && ((Text) child).getData().trim().isEmpty()) {
                element.removeChild(child);
            } else if (child instanceof Element) {
                removeWhitespaces((Element) child);
            }
        }
    }
}
