/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio1;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author a22davidil
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean continuar = true;
        Scanner entrada = new Scanner(System.in);
        File archivo = new File("empleadosGuardados.txt");
        Gestion gestion = new Gestion(archivo);
        while(continuar){
            System.out.println("Elige opcion: ");
            System.out.println("1) Consultar");
            System.out.println("2) Insertar");
            System.out.println("3) Modificar");
            System.out.println("4) Borrar");
            System.out.println("5) Listar");
            System.out.println("6) Cerrar");
            String opcion = entrada.nextLine();
            switch(opcion){
                case "1":
                    gestion.consulta();
                    break;
                case "2":
                    gestion.insercion();
                    break;
                case "3":
                    gestion.modificacion();
                    break;
                case "4":
                    gestion.borrado();
                    break;
                case "5":
                    gestion.listar();
                    break;
                case "6":
                    gestion.cerrar();
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            
        }
                
        
    }
    
}
