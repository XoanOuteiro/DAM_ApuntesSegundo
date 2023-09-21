
import java.util.Scanner;

public class ExercicioComprobadorPrimo {

    public static void main(String[] args) {

        //Valor
        double numero = 0;

        //Variable calculo
        double resto;

        //Contadores
        double contadorA = 1;
        double contadorB = 0;

        //Scanner
        Scanner lector = new Scanner(System.in);
        System.out.println("Porfavor introduza un valor a considerar: ");
        numero = lector.nextDouble();
        System.out.println("------------------------------------------");

        //Programa
        while (contadorA <= numero) {

            resto = numero % contadorA;

            if (resto == 0) {
                System.out.println("Divisible entre " + contadorA);
                contadorB++;
                System.out.println("Encontraronse " + contadorB + " dividendos");
            }

            contadorA++;
        }

        if (contadorB == 2) {
            System.out.println("O numero e primo");
        } else {
            System.out.println("O numero non e primo");
        }

    }
}
