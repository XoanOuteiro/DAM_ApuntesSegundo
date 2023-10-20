
import java.io.File;


/**
 *
 * @author XoanOuteiro
 */
public class Ex6_XMLDOM_Libros {

    public static void main(String[] args) {
        
        File f = new File("libros.xml");
        DomReader d = new DomReader(f);
        d.doRead();
        
    }
}
