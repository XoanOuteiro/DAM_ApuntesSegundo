
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



/**
 *
 * @author XoanOuteiro
 */
public class Splicer {
    
    private File inpath;
    private File outpath;
    private BufferedReader bfr;
    private BufferedWriter bfw;
    
    public Splicer(String input, String output) throws FileNotFoundException{
        
        this.inpath = new File(input);
        this.outpath = new File(output);
        
        this.bfr = new BufferedReader(new FileReader(inpath));
        
    }
    
    public void parseContents() throws IOException{
        
        String[] spliced;
        String writeable;
        int[] notas = new int[3];
        int media;
        String line = bfr.readLine();
        
        this.bfw = new BufferedWriter(new FileWriter(this.outpath));
        
        while(line != null){
            
            //Regex
            spliced = line.split(",");
            
            
            //Aislacion de campos
            String nombre = spliced[0];
            
            notas[0] = Integer.parseInt(spliced[2]);
            notas[1] = Integer.parseInt(spliced[3]);
            notas[2] = Integer.parseInt(spliced[4]);    

            //Calculo de media
            media = (notas[0] + notas[1] + notas[2])/notas.length;
            
            //Escritura
            writeable = nombre + " -> " + media + "\n";
            this.bfw.write(writeable);
            
            
            
            line = bfr.readLine();  //Flush to next line            
        }
        
        bfr.close();
        bfw.close();
    }
}
