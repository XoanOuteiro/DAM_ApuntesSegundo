
import java.io.File;


/**
 *
 * @author XoanOuteiro
 */
public class Ex7_XMLDOM_Promedio {

    public static void main(String[] args) {
        
        DomReader d = new DomReader(new File("libros2.xml"));
        
        System.out.println("Prezo promedio: " + d.getPriceAvg());
        
    }
}
