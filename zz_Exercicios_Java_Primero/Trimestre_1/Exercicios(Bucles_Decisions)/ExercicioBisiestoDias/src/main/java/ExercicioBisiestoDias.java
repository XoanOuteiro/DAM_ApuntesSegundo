/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioBisiestoDias {

    public static void main(String[] args) {
        
        //Declaration of variables
        boolean isBisiesto = true;
        int numeroMes = 6;
        
        //Algorithm
        if (numeroMes <= 12 && numeroMes >= 1){
                System.out.println("Este valor pertence a un mes");
                
                switch(numeroMes){
                    
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 9:
                    case 11:
                        System.out.println("Este mes ten 31 dias");
                        break;
                        
                    case 4:
                    case 6:
                    case 8:
                    case 10:
                    case 12:
                        System.out.println("Este mes ten 30 dias");
                        break;
                        
                    default:
                        if(isBisiesto == true)
                            System.out.println("Este mes ten 28 dias");
                        else
                            System.out.println("Este mes ten 27 dias");
                      
                }
  
        } else
            System.out.println("Este valor non pertence a un mes");
    }
}
