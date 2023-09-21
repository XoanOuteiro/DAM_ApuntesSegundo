/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioComparacionOrden {

    public static void main(String[] args) {
        
        //Declaration of variables
        int valueA = 9;
        int valueB= 12;
        int valueC = 4;
        
        //Sorting algorithm
        if (valueA > valueB && valueA > valueC)
            System.out.println("O valor A é " + valueA + " e é o maior dos tres");
        
        else if(valueB > valueA && valueB > valueC)
            System.out.println("O valor B é " + valueB + " e é o maior dos tres");
        
        else
            System.out.println("O valor C é " + valueC + " e é o maior dos tres");
    }
}
