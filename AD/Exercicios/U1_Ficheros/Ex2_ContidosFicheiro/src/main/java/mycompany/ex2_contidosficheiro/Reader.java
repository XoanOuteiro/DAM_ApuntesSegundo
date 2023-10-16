
package mycompany.ex2_contidosficheiro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author XoanOuteiro
 */
public class Reader {
    
    File f;
    BufferedReader bfr;
    
    public Reader(File f) throws FileNotFoundException{
        
        this.f = f;
        
        this.bfr = new BufferedReader(new FileReader(f));
        
    }
    
    public void printFile() throws IOException{
        
        String line = bfr.readLine();
        int i = 0;
        
        while(line != null){
            
            
            System.out.println(i + " |\t " + line);
            line = bfr.readLine();
            i++;
            
        }
        
        bfr.close();
        
    }
    
}
