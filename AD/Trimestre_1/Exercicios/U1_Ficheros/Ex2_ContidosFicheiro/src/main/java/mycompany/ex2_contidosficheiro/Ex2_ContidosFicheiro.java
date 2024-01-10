

package mycompany.ex2_contidosficheiro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XoanOuteiro
 */
public class Ex2_ContidosFicheiro {

    public static void main(String[] args) {
        
        try {
            
            File f = new File ("fichero.txt");
            
            Reader r = new Reader(f);
            
            try {
                
                r.printFile();
                
            } catch (IOException ex) {
                
                System.out.println("Erro na lectura");
                
            }
            
        } catch (FileNotFoundException ex) {
            
            System.out.println("Not found.");
            
        }
        
        
        
    }
}
