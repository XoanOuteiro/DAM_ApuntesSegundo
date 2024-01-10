
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



/**
 *
 * @author XoanOuteiro
 */
public class Counter {
    
        
    File f;
    BufferedReader bfr;
    
    public Counter(File f) throws FileNotFoundException{
        
        this.f = f;
        
        this.bfr = new BufferedReader(new FileReader(f));
        
    }
    
    public int countLine() throws IOException{
        
        String line = bfr.readLine();
        int i = -1;
        
        while(line != null){
            
            line = bfr.readLine();
            i++;
            
        }
        
        bfr.close();
        
        return i;
        
    }
    
}
