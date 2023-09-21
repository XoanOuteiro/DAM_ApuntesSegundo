/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
import java.util.Scanner;
        
public class ExercicioSalarioTraballador20 {

    public static void main(String[] args) {
        
        //Variables
        char horarioDiurno ;
        char diaLaboral ;
        int numeroHoras ;
        int salario;
        
        Scanner lector = new Scanner(System.in);
        
        //Recolector (
        System.out.println("Introduza o horario de traballo: ");
        System.out.println("[d] se foi diurno ou [n] se foi nocturno");
        horarioDiurno = lector.next().charAt(0);
        if (horarioDiurno == 'd')
            System.out.println("!-O horario e diurno");
        else if (horarioDiurno == 'n')
            System.out.println("!-O horario e nocturno");
        else
            System.out.println("ERROR: O valor engadido non e valido");
        
        System.out.println("Introduza se o dia de traballo e laborable: ");
        System.out.println("[d] se foi domingo ou [x] se foi dia laborable e sabado");
        diaLaboral = lector.next().charAt(0);
        if (diaLaboral == 'd')
            System.out.println("!-O dia foi domingo");
        else if (diaLaboral == 'x')
            System.out.println("!-O dia foi laboral ou sabado");
        else
            System.out.println("ERROR: O valor engadido non e valido");
        
        System.out.println("Introduza o numero de horas traballadas: ");
        numeroHoras = lector.nextInt();
        
        //Algoritmo
        if (diaLaboral == 'x'){
            
            if(horarioDiurno == 'd'){
                System.out.println("O salario e de: " + numeroHoras * 8);
            }
            else if (horarioDiurno == 'n') {
                System.out.println("O salario e de: " + numeroHoras * 12);   
            }   
        }
        else{
            
            if(horarioDiurno == 'd'){
                salario = numeroHoras * 8;
                double incremento = salario * 0.20;
                System.out.println("O salario e de: " + (salario+incremento) + " .O bonus foi de: " + incremento);
            }
            else if (horarioDiurno == 'n') {
                salario = numeroHoras * 12;
                double incremento = salario * 0.20;
                System.out.println("O salario e de: " + (salario + incremento) + " .O bonus foi de: " + incremento);   
            }   
        }
    }   
}
