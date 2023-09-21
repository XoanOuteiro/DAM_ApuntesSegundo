
/**
 *
 * @author a22xoanmoj
 */
import java.util.Scanner;

public class XogoNumeroAzar {

    public static void main(String[] args) {

        //Variables
        int userInput;
        Scanner lector = new Scanner(System.in);
        int numAleatorio = (int) (Math.random() * 99 + 0);
        boolean victoria = false;
        boolean debugMode = false;
        boolean isValid ;
        boolean aceptouPista = false;

        int contadorB = 0;
        int contadorA = 1;
        int resto;
        char dificultad;

        //Debug
        System.out.println("Activar modo debug?");
        System.out.println("-D- para activar, otro valor para saltar: ");
        char check = lector.next().charAt(0);
        System.out.println(check);
        int vidas = 0;
        if (check == 'D') {
            debugMode = true;
        }

        //Selector dificultade
        System.out.println("Seleccione unha dificultade: ");
        System.out.println("[a] para alta, [m] para media, [b] para baixa");

        do {

            isValid = true; //RESETTER

            dificultad = lector.next().charAt(0);
            switch (dificultad) {
                case 'a':
                    System.out.println("Dificultade alta \n 3 TURNOS");
                    vidas = 3;
                    break;

                case 'm':
                    System.out.println("Dificultade media \n 5 TURNOS");
                    vidas = 5;
                    break;

                case 'b':
                    System.out.println("Dificultade baixa \n 7 TURNOS");
                    vidas = 7;
                    break;

                default:
                    System.out.println("Esta dificultade non existe, escriba outra vez");
                    isValid = false;
            }
        } while (isValid == false);

        //Bucle do xogo
        for (int turno = 1; turno <= vidas && victoria == false; turno++) {

            //PISTA
            if (aceptouPista == false) {
                System.out.println("Desexa pista? Se di que si deixarase de preguntar");
                System.out.println("Diraselle se o número é primo e se é par:  -s- se que pista.");
                userInput = lector.next().charAt(0);
                if (userInput == 's') {
                    aceptouPista = true;
                    //ALGORITMo primOS
                    while (contadorA <= numAleatorio) {

                        resto = numAleatorio % contadorA;

                        if (resto == 0) {
                            contadorB++;
                        }

                        contadorA++;
                    }

                    if (contadorB == 2) {
                        System.out.println("O numero e primo");
                    } else {
                        System.out.println("O numero non e primo");
                    }

                    if (dificultad == 'b') {
                        if (numAleatorio % 2 == 0) {
                            System.out.println("O numero e par");
                        } else {
                            System.out.println("O numero e impar");
                        }
                    }
                }
            }

            System.out.println("TURNO: " + turno + "/" + vidas);

            if (debugMode == true) {
                System.out.println("DEBUGGER: A solucion é " + numAleatorio);
            }

            System.out.println("Introduza a sua estimacion (0-99) : ");
            userInput = lector.nextInt();
            if (userInput > 99 || userInput < 0) {
                System.out.println("ERRO: Este valor escapa os valores opcionais, sera considerado erroneo.");
            }

            //Algoritmo de xogo
            System.out.println("O teu valor foi: " + userInput);
            if (userInput < numAleatorio) {
                System.out.println(">> ERRONEO: O valor e maior ca o que introduciches");
            } else if (userInput > numAleatorio) {
                System.out.println(">> ERRONEO: O valor e menor ca o que introduciches");
            } else {
                victoria = true;
                System.out.println("!>> CORRECTO: acertaches o numero");
            }
            System.out.println("-----------------------------");

        }
        if (victoria == false) {
            System.out.println("Perdiches, o valor era: " + numAleatorio);
        }
    }
}
