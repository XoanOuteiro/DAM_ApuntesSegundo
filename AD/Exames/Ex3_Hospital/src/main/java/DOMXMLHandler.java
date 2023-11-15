
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
 * @author XoanOuteiro
 */
public class DOMXMLHandler {

    //Atributes
    private final String URL = "files/System.xml";

    private File refSystem;

    //Builders
    public DOMXMLHandler() {

        try {

            this.refSystem = new File(this.URL);

            this.init(this.refSystem);

        } catch (IOException ex) {

            System.out.println("Failed to create file, please run program as admin to have propper write permissions.");

        }

    }

    //Methods
    public void doPush(ArrayList<Paciente> pacientes) throws IOException {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Pacientes");
            doc.appendChild(rootElement);

            for (Paciente paciente : pacientes) {

                Element pacienteElement = doc.createElement("Paciente");
                rootElement.appendChild(pacienteElement);

                Element nifElement = doc.createElement("NIF");
                nifElement.appendChild(doc.createTextNode(paciente.getNif()));
                pacienteElement.appendChild(nifElement);

                Element nombreElement = doc.createElement("Nombre");
                nombreElement.appendChild(doc.createTextNode(paciente.getNombre()));
                pacienteElement.appendChild(nombreElement);

                Element apellidosElement = doc.createElement("Apellidos");
                apellidosElement.appendChild(doc.createTextNode(paciente.getApellidos()));
                pacienteElement.appendChild(apellidosElement);

                Element direccionElement = doc.createElement("Direccion");
                direccionElement.appendChild(doc.createTextNode(paciente.getDireccion()));
                pacienteElement.appendChild(direccionElement);
                
                Element fechaElement = doc.createElement("fecha_ultima");
                if(paciente.getFechaUltimaVisita() == null){
                    
                    fechaElement.appendChild(doc.createTextNode(""));
                    
                }else{
                    
                    fechaElement.appendChild(doc.createTextNode(paciente.getFechaUltimaVisita().toString()));
                    
                }
                pacienteElement.appendChild(fechaElement);
                
                String alergia;
                
                if(paciente.isAlergia()){
                    
                    alergia = "true";
                    
                }else{
                    
                    alergia = "false";
                    
                }
                
                Element alergiaElement = doc.createElement("Alergia");
                alergiaElement.appendChild(doc.createTextNode(alergia));
                pacienteElement.appendChild(alergiaElement);
                
                Element tipoElement = doc.createElement("Tipo");
                tipoElement.appendChild(doc.createTextNode(paciente.getTipo()+""));
                pacienteElement.appendChild(alergiaElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(refSystem);

            // Save the XML to the file specified in refSystem (overwriting it)
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

        } catch (Exception e) {

            throw new IOException("Error when writing pacientes to XML" + e.getLocalizedMessage());

        }
    }

    public ArrayList<Paciente> doPull() throws NullPointerException {
        try {

            ArrayList<Paciente> pacientes = new ArrayList<>();
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(refSystem);
            doc.getDocumentElement().normalize();

            NodeList pacienteNodes = doc.getElementsByTagName("Pacientes");

            for (int i = 0; i < pacienteNodes.getLength(); i++) {

                Element pacienteElement = (Element) pacienteNodes.item(i);
                String nif = pacienteElement.getElementsByTagName("NIF").item(0).getTextContent();
                String nombre = pacienteElement.getElementsByTagName("Nombre").item(0).getTextContent();
                String apellidos = pacienteElement.getElementsByTagName("Apellidos").item(0).getTextContent();
                String direccion = pacienteElement.getElementsByTagName("Direccion").item(0).getTextContent();
                String alergiatxt = pacienteElement.getElementsByTagName("Alergia").item(0).getTextContent();
                boolean alergia;
                if(alergiatxt.equals("true")){
                    
                    alergia = true;
                   
                }else{
                    
                    alergia = false;
                    
                }
                char tipo = pacienteElement.getElementsByTagName("Tipo").item(0).getTextContent().charAt(0);

                Paciente paciente = new Paciente(nif, nombre, apellidos, direccion,alergia,tipo);

                pacientes.add(paciente);
            }

            return pacientes;

        } catch (Exception e) {

            throw new NullPointerException("Error when pulling pacientes from XML" + e.getLocalizedMessage());

        }
    }

    private void init(File f) throws IOException {

        if (!f.exists()) {
            f.createNewFile();
        }
    }

    public ArrayList<Paciente> startFlowSequence() {

        try { //Check if file is empty trying to obtain data

            ArrayList<Paciente> returnable = this.doPull();
            return returnable; //If the import is succesful the method breaks here

        } catch (Exception ex) {    //If the exception is caught we assume that our file is empty
            
            /*
                We ensure that this part is only a first-time executable imprinting a
                default empty header for our XML
             */
            try {

                ArrayList<Paciente> header = new ArrayList<Paciente>();

                this.doPush(header);

                return header;

            } catch (Exception err) {

                //If the reference hasn't failed, this is objectively unreachable
                System.out.println("Fatal error: Reference not found and impossible to create, please run program as admin. \n NONE OF YOUR CHANGES WILL BE SAVED");

            }

        }

        return null;    //Final absolute nullable.

    }
}
