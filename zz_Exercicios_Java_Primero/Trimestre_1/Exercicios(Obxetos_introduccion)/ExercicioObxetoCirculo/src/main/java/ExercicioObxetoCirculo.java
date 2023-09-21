/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
import java.util.Scanner;
public class ExercicioObxetoCirculo {

    public static void main(String[] args) {
        System.out.println("Introduza un radio");
        Scanner lector = new Scanner(System.in);
        int var = lector.nextInt();
        
        Circulo circulo1 = new Circulo(var);
        System.out.println("O circulo creado polo usuario e de radio: " + circulo1.getRadio());
        
        Circulo circulo2 = new Circulo (7);
        System.out.println("O circulo creado polo ordenador foi de radio: " + circulo2.getRadio());
        
        //Exercicio 3
        circulo2.MultiplicaRadio();
        System.out.println("O circulo creado polo ordenador E DUPLICADO POR METODO e de radio: " + circulo2.getRadio());
    }
}
