
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author XoanOuteiro
 */
public class BinBuilder {

    private String filepath;
    final int MAX_BYTES = 2048;
    final int BUFFER_SIZE = 32;

    public BinBuilder(String f) {

        this.filepath = f;

    }

    public void toBinary(String outputFilePath) {
        
        try (FileInputStream fileInputStream = new FileInputStream(filepath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            int totalBytes = 0;

            while ((bytesRead = fileInputStream.read(buffer)) != -1 && totalBytes < MAX_BYTES) {
                
                for (int i = 0; i < bytesRead && totalBytes < MAX_BYTES; i++) {
                    
                    String hex = String.format("%02X ", buffer[i]);
                    System.out.print(hex); 
                    fileOutputStream.write(hex.getBytes());
                    totalBytes++;
                    
                }
                
                System.out.println(); 
                fileOutputStream.write("\n".getBytes()); 
                
            }
            
        } catch (IOException e) {
            
            System.err.println("Error al leer o escribir en el archivo: " + e.getMessage());
            
        }
    }

}
