/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
import java.util.Scanner;
public class ExercicioComparacionCadea {

    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        System.out.println("Introduza 3 enunciados: ");
        Chain consider1 = new Chain(reader.nextLine(),reader.nextLine(),reader.nextLine());
        System.out.println(consider1.maior());
    }
}
