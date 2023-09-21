package customouteiro.exercicioprimosmenorescanumero;

/**
 *
 * @author a22xoanmoj
 */

import java.util.Scanner;

public class ExercicioPrimosMenoresCaNumero {

    public static void main(String[] args) {
        
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduza un número: ");
        int valor = lector.nextInt();
        boolean primo ;
        
        for(int contador = 1 ; contador < valor ; contador++){
            
            primo = true;
            
            for(int considerar = 2 ; considerar < contador && primo ; considerar++){
                
                if(contador % considerar == 0)
                    primo = false;
                
            }
            if(primo)
                System.out.println("O numero " + contador + " e primo");
        }
    }
}
