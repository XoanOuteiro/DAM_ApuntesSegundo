/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
import java.util.Scanner;
        
public class ExercicioTeoremaPitagoras {

    public static void main(String[] args) {
        
        //scanner
        Scanner scanner = new Scanner(System.in);
        
        //Declaration of variables
        int valueA = 9;
        int valueB = 6;
        int hipotenusa ;
        
        System.out.println("Porfavor, introduzca valor 1: ");
        valueA = scanner.nextInt();
        System.out.println("Porfavor, introduzca valor 2: ");
        valueB = scanner.nextInt();
        
        //Algorithm
        System.out.println("A hipotenusa e " + Math.sqrt( (valueA*valueA) + (valueB*valueB) ));
        
        
    }
}
