
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
/**
 *
 * @author a22xoanmoj
 */
public class ExercicioRepetirTaboasUsuario {

    public static void main(String[] args) {
        //Variables
        
        Scanner lector = new Scanner(System.in);
        char userInput;

        do {
            System.out.println("\n" + "----^^^^REPETICION^^^^----" + "\n");

            for (int contadorPr = 1; contadorPr <= 9; contadorPr++) {

                for (int contadorSec = 0; contadorSec <= 10; contadorSec++) {
                    System.out.println(contadorPr + " * " + contadorSec + " = " + contadorPr * contadorSec);
                }

                System.out.println("-----------------------------");
            }
            
            System.out.println("Desexa re-dibuxar as tablas?");
            System.out.println("Escriba [n] para cancelar a repeticion.");
            System.out.println("Escriba [s] para continuar a repeticion");
            System.out.println("Presione [ENTER] para continuar.");
            userInput = lector.next().charAt(0);
               
        } while (userInput == 's');
    }
}
