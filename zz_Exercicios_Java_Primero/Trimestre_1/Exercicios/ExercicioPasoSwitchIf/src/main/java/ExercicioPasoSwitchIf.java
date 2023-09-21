/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioPasoSwitchIf {

    public static void main(String[] args) {
        
        //Declaratin of variables
        int quali = 5;
        
        //Sorting 
        switch(quali){
            
            case 10:
                System.out.println("Matricula de Honor");
                break;
                
            case 9:
                System.out.println("Sobresaliente");
                break;
                
            case 8:
            case 7:
                System.out.println("Notable");
                break;
                
            case 6:
                System.out.println("Bien");
                break;
                
            case 5:
                System.out.println("Aprobado");
                break;
                
            default:
                System.out.println("Suspenso");
                break;

                
             
        }
        
        
    }
}
