
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author XoanOuteiro
 */
public class Ex4_ContarLineas {

    public static void main(String[] args) {
        
        try {
            
            Counter c = new Counter(new File("fichero.txt"));
            
            System.out.println("El fichero tiene: " + c.countLine() + " lineas.");
            
        } catch (IOException ex) {
            
            Logger.getLogger(Ex4_ContarLineas.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
