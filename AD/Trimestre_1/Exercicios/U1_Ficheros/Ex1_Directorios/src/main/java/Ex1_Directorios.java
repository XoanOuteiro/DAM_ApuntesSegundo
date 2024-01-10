
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author XoanOuteiro
 */
public class Ex1_Directorios {

    public static void main(String[] args) {
        
        Parser p = new Parser();
        
        Scanner reads = new Scanner(System.in);
        
        System.out.println("Quieres especificar una ruta? 1-> Si , 2-> No");
        int opt = reads.nextInt();
        reads.nextLine(); //Flush buffer
        
        if(opt == 1){
            
            System.out.println("Indique a dirección");
            String dir = reads.nextLine();
            
            try {
                
                p.switchType(dir);
                
            } catch (IOException ex) {
                
                System.out.println("ERROR: URL invalida");
                
            }
            
        }if(opt == 2){
           
            try {
                
                p.switchType(".");
                
            } catch (IOException ex) {
                
                System.out.println("ERROR: URL invalida");
                
            }
            
        }
    }
}
