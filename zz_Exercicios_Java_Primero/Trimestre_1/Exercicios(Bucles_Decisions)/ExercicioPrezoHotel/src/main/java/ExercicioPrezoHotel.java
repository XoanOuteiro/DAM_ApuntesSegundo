/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioPrezoHotel {

    public static void main(String[] args) {
        
        //Declaration of variables
        int idade = 70;
        
        boolean carnetUniversidad = false;
        boolean carnetXubilado = false;          //!!Asumese que un xubilado non e parado
        boolean familiaNumerosa = false;
        boolean parado = false;
        
        //podemos asumir o risco de que o usuario marque parado e xubilado como
        //true debido a que o OR en computación devolve o valor true
        
        //Sort
        if (idade <= 30){
            
            if ( carnetUniversidad && parado )
            System.out.println("O prezo da habitación é 35€. ");
            else if( carnetUniversidad || parado )
                System.out.println("O prezo da habitación é 40€. ");
            else
                System.out.println("O prezo da habitación é 50€. ");    
        }
        else if ( idade >= 55 ){
            
            if ( carnetXubilado || parado )
                System.out.println("O prezo da habitación é 45€. ");
            else
                System.out.println("O prezo da habitación é 60€");
        }
        else{
            
            if ( familiaNumerosa )
                System.out.println("O prezo da habitación é 65€.");
            else 
                System.out.println("O prezo da habitación é 75€. ");
        }  
    }
}
