/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioFactorialWhile {

    public static void main(String[] args) {
        //Declaracion de variables
        int valor = 5;
        int control = valor;
        int valorAlt = valor;
        int i = 1;
        
        
        //Factorial
        while ( i < control ) {
            valor *= i;
            System.out.println("DEBUGGING: " + valor + "/" + i);
            i++;
        }
        
        //Factorial en for
        System.out.println("-------------Version en for----------");
        
        for (int contadorB = valorAlt ; contadorB > 1 ; contadorB--){
            valorAlt *= contadorB;
            System.out.println("DEBUGGING: " + valorAlt + "/" + contadorB);
        }
        
        System.out.println("O factorial é: " + valor);
        System.out.println("O factorial(for) é: " + valorAlt);
    }
}
