
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
/**
 *
 * @author a22xoanmoj
 */
public class ExercicioCalendarioAdvento {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println(">Waiting for: fill method: swapRand[true] or checkerArray[false] ? [true/false]");
        CalendarioAdvento cal1 = new CalendarioAdvento(reader.nextBoolean());

        System.out.println(">Waiting for: set variable input as auto ?");
        boolean auto = reader.nextBoolean();
        if (!auto) {
            for (int cont1 = 1; cont1 <= 24; cont1++) {
                System.out.println(">>Waiting for: day?: [" + cont1 + "/24]");
                int input = reader.nextInt();
                cal1.comer(input);
            }
        } else {
            for (int cont1 = 1; cont1 <= 24; cont1++) {
                System.out.println(">>At: [" + cont1 + "/24]");
                cal1.comer(cont1);
            }
        }
        System.out.println("!**>>Chegou o nadal!");

    }
}
