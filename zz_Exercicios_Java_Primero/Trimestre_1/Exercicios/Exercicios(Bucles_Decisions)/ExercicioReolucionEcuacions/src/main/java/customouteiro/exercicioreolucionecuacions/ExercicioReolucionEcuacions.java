/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package customouteiro.exercicioreolucionecuacions;

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioReolucionEcuacions {

    public static void main(String[] args) {
        
        //Declaration of variables
        int a = 3;
        int b = 5;
        int c = 1;
        
        double solutionPos = (-b + (Math.sqrt((b*b)-(4*a*c)))/2*a);
        double solutionNeg = (-b - (Math.sqrt((b*b)-(4*a*c)))/2*a);
        
        System.out.println("As solucions son: " + solutionPos + " e " + solutionNeg);
        
    }
}
