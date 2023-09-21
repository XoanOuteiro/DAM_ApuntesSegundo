
import java.util.Arrays;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioCalculadoraMatricial {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println(">Waiting for: porDefecto? [true/false]  1/2");
        Matriz mop1 = new Matriz(reader.nextBoolean());
        System.out.println(">Waiting for: porDefecto? [true/false]  2/2");
        Matriz target_matrix = new Matriz(reader.nextBoolean());
        Matriz resultado_suma = mop1.sumar_matriz(target_matrix);
        resultado_suma.mostrar_matriz(resultado_suma.getMain_matrix());
    }
}
