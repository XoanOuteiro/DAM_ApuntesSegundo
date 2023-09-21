/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
import java.util.Scanner;

public class ExercicioTarot {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        System.out.println("Introduza un dia: ");
        int dia = lector.nextInt();
        System.out.println("Introduzca un mes: ");
        int mes = lector.nextInt();
        System.out.println("Introduzca un ano: ");
        int ano = lector.nextInt();

        //Comprobador @victorlanguin
        boolean bis = ano % 4 == 0;
        boolean correcto = true;
        int temporal;
        int resultado = 0;

        if (mes > 12 || dia > 31) {
            correcto = false;
        }
        switch (mes) {
            case 4,6,9,11:
                if (dia > 30) {
                    correcto = false;
                }
                break;
            case 2:
                if (bis && dia > 29 || !bis && dia > 28) {
                    correcto = false;
                }
                break;
            default:
        }

        if (!correcto) {
            System.out.println("ERROR: Un ou varios valores non son validos.");
            
        } else {
            temporal = ano + mes + dia;
            while (temporal > 10) {
                resultado = (temporal % 10) + resultado;
                temporal = temporal / 10;
            }
            resultado += temporal;
            if (resultado >= 10) {
                resultado = resultado % 10 + resultado / 10;
            }
            System.out.println("El valor del tarot para " + dia + "/" + mes + "/" + ano + " es " + resultado);

            //Numero tarot logic
        }

    }
}
