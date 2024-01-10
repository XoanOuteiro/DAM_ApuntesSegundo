
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;


/**
 *
 * @author a14carlosfd adaptado XoanOuteiro
 */
public class Factory {
    
    SAXParserFactory factory;

    SAXParser parser;

    public Factory() {
        
        try {
            
            factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            
        } catch (ParserConfigurationException | SAXException ex) {
            
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    public void cargarDatos(String pathname) {
        
        try {
            
            File archivo = new File(pathname);

            Parser handler = new Parser();
            parser.parse(pathname, handler);
            

        } catch (SAXException | IOException ex) {
            
            System.out.println(ex.getMessage());
            
        }

    }
    
}
