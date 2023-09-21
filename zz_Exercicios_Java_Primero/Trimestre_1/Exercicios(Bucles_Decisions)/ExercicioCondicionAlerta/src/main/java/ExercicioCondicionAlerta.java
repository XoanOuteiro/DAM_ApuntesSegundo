/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioCondicionAlerta {

    public static void main(String[] args) {
        
        //Declaration of variables
        int humidity = 94;  //percentage
        int temperature = 21; //Celsius
        
        //Compare algorithm
        if ( humidity >= 50 && temperature >= 24)
            System.out.println("Alerta vermella");
        
        else if( humidity > 50 || temperature > 24)
            System.out.println("Alerta amarela");
        
        else
            System.out.println("Alerta verde");
          
    }
}
