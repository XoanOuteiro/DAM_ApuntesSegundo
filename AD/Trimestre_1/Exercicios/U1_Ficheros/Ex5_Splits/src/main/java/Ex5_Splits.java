
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author XoanOuteiro
 */
public class Ex5_Splits {

    public static void main(String[] args) {
        
        try {
            
            Splicer s = new Splicer("input.txt","output.txt");
            s.parseContents();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        }
        
    }
}
