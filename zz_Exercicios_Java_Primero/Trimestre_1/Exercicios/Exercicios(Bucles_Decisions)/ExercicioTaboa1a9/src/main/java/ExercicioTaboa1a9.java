/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
import java.util.Scanner;

public class ExercicioTaboa1a9 {

    public static void main(String[] args) {

        //Variables
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduza o numero de veces que queres que se mostren todas as tablas");
        int index = lector.nextInt();

        for (int contadorRep = 1; contadorRep <= index; contadorRep++) {

            System.out.println("\n" + "----^^^^ESTA E A REPETICION " + contadorRep + "^^^^----" + "\n");

            for (int contadorPr = 1; contadorPr <= 9; contadorPr++) {

                for (int contadorSec = 0; contadorSec <= 10; contadorSec++) {
                    System.out.println(contadorPr + " * " + contadorSec + " = " + contadorPr * contadorSec);
                }

                System.out.println("-----------------------------");
            }
        }
    }
}
