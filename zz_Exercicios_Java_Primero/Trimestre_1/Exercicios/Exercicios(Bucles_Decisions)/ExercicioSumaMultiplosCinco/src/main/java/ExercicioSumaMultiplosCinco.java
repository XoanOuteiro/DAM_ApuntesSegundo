/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioSumaMultiplosCinco {

    public static void main(String[] args) {
        
        //Variables base
        int numeroDadoA = 5;
        int numeroDadoB = 15;

        //Bucle
        int contador = numeroDadoA;
        int sumatorio = 0;
        
        //Algoritmo
        if (numeroDadoA < 0 || numeroDadoB < 0)
            
            System.out.println("ERROR; os valores deben ser positivos");
        
        else{
            
            if( numeroDadoA > numeroDadoB ){
                
            System.out.println("ERROR: Os valores seran invertidos antes de continuar ");
            int almacenCambio ;
            almacenCambio = numeroDadoA;
            numeroDadoA = numeroDadoB;
            numeroDadoB = almacenCambio;
            }
        

            while ( contador <= numeroDadoB ){
                
             if (contador%5 == 0)
              sumatorio += contador;
             
              contador++;
            }
            System.out.println("O sumatorio de multiplos de 5 entre " + numeroDadoA + " e " + numeroDadoB + " = " + sumatorio);
        }       
    }
}
