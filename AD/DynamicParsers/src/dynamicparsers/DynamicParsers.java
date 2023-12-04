
package dynamicparsers;

import Validators.Validator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * Main class to conduct tests on different parsers
 * 
 * @author XoanOuteiro
 */
public class DynamicParsers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Validator v = new Validator();
        System.out.println(v.checkNif("00000000T"));
        System.out.println(v.checkNif("000D00003"));
        System.out.println(v.checkNif("000000002"));
        
        Scanner reads = new Scanner(System.in);
        String in = reads.nextLine();
        try{
            
            float f = v.parseDataFloat(in);
            System.out.println(f);
            
        }catch(InputMismatchException e){
            
            System.out.println(e.getLocalizedMessage());
            
        }
        
    }
    
}
