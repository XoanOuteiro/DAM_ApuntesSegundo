
package view;

import java.util.Scanner;

/**
 *
 * @author XoanOuteiro
 * 
 */
public class MenuBuilder {
    
    
    public MenuBuilder(){
        
        this.initMainMenu();
        
    }
    
    public void initMainMenu(){
        
        boolean hasExited = false;
        Scanner reads = new Scanner(System.in); 
        
        do{
            System.out.println("1-> Query all users");
            System.out.println("2-> Query users by DNI/NIF");
            System.out.println("3-> Query users by salary (> than input)");
            System.out.println("4-> Query users by salary (<= than input)");
            System.out.println("0-> Exit");
            System.out.println("Waiting for user input ... ");
            
            String input = reads.nextLine();
            
            
            
        }while(!hasExited);
    }
}
