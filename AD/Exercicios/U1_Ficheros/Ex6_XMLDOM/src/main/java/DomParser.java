
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author XoanOuteiro
 */
public class DomParser {
    
    private DocumentBuilderFactory dbf;
    private DocumentBuilder builder;
    
    private DOMImplementation implementation;
    
    private Document registroEmpleados;
    
    
    public DomParser(){
        
        try {
            
            this.dbf = DocumentBuilderFactory.newInstance();
            this.builder = dbf.newDocumentBuilder();
            
            this.implementation = builder.getDOMImplementation();
            this.registroEmpleados = this.implementation.createDocument(null, "empleados", null);
            
        } catch (Exception ex) {
            
            System.out.println("ERROR: Init of DomParser of type " + ex.getClass() + " " + ex.getLocalizedMessage());
            
        }
 
    }
    
    public void domStamp(){
        
        Element empleado = registroEmpleados.createElement("empleado");
        registroEmpleados.getDocumentElement().appendChild(empleado);
        
        Element id = registroEmpleados.createElement("id");
        
        Text texto = registroEmpleados.createTextNode("01");
        
        id.appendChild(texto);
        empleado.appendChild(id);
        
        Element nombre = registroEmpleados.createElement("nombre");
        texto = registroEmpleados.createTextNode("Antonio");
        nombre.appendChild(texto);
        empleado.appendChild(nombre);
        
        Element apellidos = registroEmpleados.createElement("apellido");
        texto = registroEmpleados.createTextNode("Morales");
        apellidos.appendChild(texto);
        empleado.appendChild(apellidos);

        guardarArchivo();
        
    }
    
    public void guardarArchivo(){
        
        try {
            
            Source origen = new DOMSource(registroEmpleados);
            Result resultado = new StreamResult(new File("Empleados.xml"));
            Transformer transformador = TransformerFactory.newInstance().newTransformer();
            
            transformador.setOutputProperty(OutputKeys.INDENT, "yes");
            
            transformador.transform(origen, resultado);
            
        } catch (Exception ex) {
            
            Logger.getLogger(DomParser.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
}
