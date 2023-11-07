package Data;

import Model.Empleado;

import java.util.ArrayList;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
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


    public ArrayList<Empleado> retrieveFromXML() throws Exception {
        try {
            ArrayList<Empleado> empleados = new ArrayList<>();

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                private Empleado currentEmpleado;
                private StringBuilder currentData;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    currentData = new StringBuilder();
                    if (qName.equals("Empleado")) {
                        currentEmpleado = new Empleado("0","0","0",0);
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (currentData != null) {
                        currentData.append(ch, start, length);
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    switch (qName) {
                        case "NIF" -> currentEmpleado.setNif(currentData.toString().trim());
                        case "Nombre" -> currentEmpleado.setNombre(currentData.toString().trim());
                        case "Apellidos" -> currentEmpleado.setApellidos(currentData.toString().trim());
                        case "Salario" -> currentEmpleado.setSalario(Float.parseFloat(currentData.toString().trim()));
                        case "Empleado" -> {
                            empleados.add(currentEmpleado);
                            currentEmpleado = null;
                        }
                    }
                    currentData = null;
                }
            };

            saxParser.parse(refSystem, handler);

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
