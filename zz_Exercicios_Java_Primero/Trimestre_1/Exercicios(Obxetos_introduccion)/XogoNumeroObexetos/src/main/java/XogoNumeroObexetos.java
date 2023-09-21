/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
import java.util.Scanner;

public class XogoNumeroObexetos {

    public static void main(String[] args) {
        Scanner inputer = new Scanner(System.in);

        //Solicitude
        System.out.println("Introduza un valor minimo e un valor maximo para o xogo, nese orden.");
        int input1 = inputer.nextInt();
        int input2 = inputer.nextInt();
        System.out.println("Agora introduza o numero de turnos que desexa ter");
        int input3 = inputer.nextInt();

        //Creacion da Partida
        //System.out.println(">>DEBUG: Will create new match");
        Partida partida1 = new Partida(input1, input2, input3);
        //System.out.println(">>DEBUG: Will call game runner");
        System.out.println("[numero] + [enter] para xogar");
        partida1.turnRunner();

    }
    
}
