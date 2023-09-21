/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
import java.util.Scanner;

public class ExercicioBoligrafoObxeto {

    public static void main(String[] args) {
        Pen pen1 = new Pen();
        Scanner reader = new Scanner(System.in);
        System.out.println("Your pen has  " + pen1.getInk());
        System.out.println("Insert amount of words to write as < 30 int");
        int input = reader.nextInt();
        System.out.println(pen1.writeAmountOfWords(input));
    }
}
