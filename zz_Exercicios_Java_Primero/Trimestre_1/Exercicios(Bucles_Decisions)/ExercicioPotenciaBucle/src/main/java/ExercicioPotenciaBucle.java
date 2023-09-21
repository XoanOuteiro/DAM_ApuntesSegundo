/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioPotenciaBucle {

    public static void main(String[] args) {
        
        int numero1 = 2;
        int control = numero1;
        int numero2 = 3;
        
        for (int i = 1 ; i < numero2 ; i++){
            numero1 *= control;
            //System.out.println("DEBUGGER: " + i + "//" + numero2 + "//" + numero1);
        }
        
        System.out.println("A potencia é " + numero1);
    }
}
