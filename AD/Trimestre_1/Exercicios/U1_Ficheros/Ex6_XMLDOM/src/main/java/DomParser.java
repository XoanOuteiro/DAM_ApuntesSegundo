
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
        
        crearPersona("01","Antonio","Morales");
        
        crearPersona("02","Brais","Diaz");
                

        guardarArchivo();
        
    }
    
    public void crearPersona(String id, String nombre, String apellido){
        
        Element empleado = registroEmpleados.createElement("empleado");
        registroEmpleados.getDocumentElement().appendChild(empleado);
        
        Element id_ = registroEmpleados.createElement("id");
        
        Text texto = registroEmpleados.createTextNode(id);
        
        id_.appendChild(texto);
        empleado.appendChild(id_);
        
        Element nombre_ = registroEmpleados.createElement("nombre");
        texto = registroEmpleados.createTextNode(nombre);
        nombre_.appendChild(texto);
        empleado.appendChild(nombre_);
        
        Element apellido_ = registroEmpleados.createElement("apellido");
        texto = registroEmpleados.createTextNode(apellido);
        apellido_.appendChild(texto);
        empleado.appendChild(apellido_);
        
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
