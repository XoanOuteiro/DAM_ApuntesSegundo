package Data;

import Model.Empleado;

import java.util.ArrayList;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * Allows for the input and output of savestates
 *
 * @author XoanOuteiro
 */
public class DataHandler {

    //Atributes
    private final String URL = "files/System.xml";

    private File refSystem;




    //Builders
    public DataHandler(){
        
        try{

            this.refSystem = new File(this.URL);

            this.init(this.refSystem);

        }catch (IOException ex){

            System.out.println("Failed to create file, please run program as admin to have propper write permissions.");

        }

    }

    //Methods
    public void savestateXML(ArrayList<Empleado> empleados) throws IOException {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Empleados");
            doc.appendChild(rootElement);

            for (Empleado empleado : empleados) {
                
                Element empleadoElement = doc.createElement("Empleado");
                rootElement.appendChild(empleadoElement);

                Element nifElement = doc.createElement("NIF");
                nifElement.appendChild(doc.createTextNode(empleado.getNif()));
                empleadoElement.appendChild(nifElement);

                Element nombreElement = doc.createElement("Nombre");
                nombreElement.appendChild(doc.createTextNode(empleado.getNombre()));
                empleadoElement.appendChild(nombreElement);

                Element apellidosElement = doc.createElement("Apellidos");
                apellidosElement.appendChild(doc.createTextNode(empleado.getApellidos()));
                empleadoElement.appendChild(apellidosElement);

                Element salarioElement = doc.createElement("Salario");
                salarioElement.appendChild(doc.createTextNode(String.valueOf(empleado.getSalario())));
                empleadoElement.appendChild(salarioElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(refSystem);

            // Save the XML to the file specified in refSystem (overwriting it)
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

        } catch (Exception e) {

            throw new IOException("Error when writing empleados to XML");

        }
    }


    public ArrayList<Empleado> retrieveFromXML() {
        try {
            
            ArrayList<Empleado> empleados = new ArrayList<>();
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(refSystem);
            doc.getDocumentElement().normalize();

            NodeList empleadoNodes = doc.getElementsByTagName("Empleado");
            
            for (int i = 0; i < empleadoNodes.getLength(); i++) {
                
                Element empleadoElement = (Element) empleadoNodes.item(i);
                String nif = empleadoElement.getElementsByTagName("NIF").item(0).getTextContent();
                String nombre = empleadoElement.getElementsByTagName("Nombre").item(0).getTextContent();
                String apellidos = empleadoElement.getElementsByTagName("Apellidos").item(0).getTextContent();
                float salario = Float.parseFloat(empleadoElement.getElementsByTagName("Salario").item(0).getTextContent());

                Empleado empleado = new Empleado(nif, nombre, apellidos, salario);
                
                empleados.add(empleado);
            }

            return empleados;
            
        } catch (Exception e) {

            throw new NullPointerException("Error when pulling empleados from XML");

        }
    }

    private void init(File f) throws IOException {
        
        if (!f.exists()) {
            f.createNewFile();
        }
    }
    
        public ArrayList<Empleado> doImportSequence() {

        try{ //Check if file is empty trying to obtain data

            ArrayList<Empleado> returnable = this.retrieveFromXML();

            return returnable; //If the import is succesful the method breaks here

        }catch(Exception ex){    //If the exception is caught we assume that our file is empty

            /*
                We ensure that this part is only a first-time executable imprinting a
                default empty header for our XML
             */

            try {

                ArrayList<Empleado> header = new ArrayList<Empleado>();

                this.savestateXML(header);

                return header;

            } catch (Exception err) {

                //If the reference hasn't failed, this is objectively unreachable
                System.out.println("Fatal error: Reference not found and impossible to create, please run program as admin. \n NONE OF YOUR CHANGES WILL BE SAVED");

            }

        }

        return null;    //Final absolute nullable.

    }

}
