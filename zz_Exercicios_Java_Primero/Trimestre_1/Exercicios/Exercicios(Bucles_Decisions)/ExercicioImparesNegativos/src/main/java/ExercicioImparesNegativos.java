/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioImparesNegativos {

    public static void main(String[] args) {
        
        int i = -1;
        int n = -1;
        
        while (i >= -10){
            if( n%2 == -1){
                i--;
                System.out.println(n);
            }
            n--;    
        }
    }
}
