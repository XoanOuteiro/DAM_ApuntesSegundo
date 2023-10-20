
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author XoanOuteiro
 */
public class DomReader {

    private Document document;

    public DomReader(File f) {

        try {

            this.document = init(f);

        } catch (Exception ex) {

            Logger.getLogger(DomReader.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    private Document init(File f) throws ParserConfigurationException, SAXException, IOException {

        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Build Document
        Document document = builder.parse(f);

        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();

        return document;

    }

    public void doRead() {

        Element root = document.getDocumentElement();

        System.out.println("Elemento raiz: " + root.getNodeName());

        NodeList nList = this.document.getElementsByTagName("libro");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Print each employee's detail
                Element eElement = (Element) node;
                System.out.println("\nTitulo : " + eElement.getElementsByTagName("titulo").item(0).getTextContent());
                System.out.println("Autor : " + eElement.getElementsByTagName("autor").item(0).getTextContent());
                System.out.println("Año : " + eElement.getElementsByTagName("anio").item(0).getTextContent());
            }
        }

    }

}
