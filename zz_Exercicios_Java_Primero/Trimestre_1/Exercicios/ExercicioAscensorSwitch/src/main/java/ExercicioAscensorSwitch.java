/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioAscensorSwitch {

    public static void main(String[] args) {
        
        //Declaration of variables
        char userInput = 's'; 
        
        //Sorter
        switch(userInput){
                
                case 'a':
                    System.out.println("Abrir");
                    break;
                    
                case 'b':
                    System.out.println("Baixar");
                    break;
                    
                case 's':
                    System.out.println("Subindo");
                    break;
                    
                case 'p':
                    System.out.println("Pechando");
                    break;
                    
                default:
                    System.out.println("Error, input non valido");
        }
    }
}
