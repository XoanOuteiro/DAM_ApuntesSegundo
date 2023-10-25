
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author XoanOuteiro
 */
public class Parser extends DefaultHandler {

    private StringBuilder value;

    public Parser() {
        
        this.value = new StringBuilder();
        
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        this.value.setLength(0);

        if (qName.equals("libro")) {

            String ano = attributes.getValue("año");
            
            System.out.println("Ano del libro: " + ano);
            
        }

        if (qName.equals("autor")) {
            
            System.out.println("Autor : ");
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        this.value.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        switch (qName) {
            
            case "ano" ->
                
                System.out.println("ano: " + this.value.toString());
                
            case "titulo" ->
                
                System.out.println("titulo: " + this.value.toString());
                
            case "apellido" ->
                
                System.out.println("    apellido : " + this.value.toString());
                
            case "nombre" ->
                
                System.out.println("    nombre : " + this.value.toString());
                
            case "editorial" ->
                
                System.out.println("editorial: " + this.value.toString());
                
            case "precio" ->
                
                System.out.println("precio: " + this.value.toString());
                
            case "libro" ->
                
                System.out.println();

        }

    }

}
