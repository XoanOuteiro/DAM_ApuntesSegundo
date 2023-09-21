/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioResolucionBool {

    public static void main(String[] args) {
        
        // Exercicio a resolver: 3+5<5*2||3>8&&7>6-2
        
        boolean leftSideOR = 3+5 < 5*2;
        boolean rightSideORLeft = 3>8;
        boolean rightSideORRight = 7>6-2;
        boolean rightSideOR = rightSideORLeft && rightSideORRight;
        
        boolean solution = leftSideOR || rightSideOR;
        
        //Print
        System.out.println("A solucion e: " + solution);
    }
}
