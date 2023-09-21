/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioConversionHoras {

    public static void main(String[] args) {
        
        //Variable Declaration
        float amountSeconds = 150000f;
        
        
        //funcion
        int amountHoursOperator = (int) (amountSeconds/3600);
        int amountMinutesOperator = (int) (amountSeconds%3600);
        int amountMinutes = amountMinutesOperator/60;
        int amountSecondsOperator = amountMinutes%60;
        int amountSecondsFinal = amountSecondsOperator/60;
        
        
        //Print
        System.out.println(amountSeconds + " segundos son: " + amountHoursOperator + "horas " + amountMinutes + "minutos " + amountSecondsFinal + "segundos");
        
        
        //debuggers
        //System.out.println(amountSecondsOperator);
        //System.out.println(amountHoursOperator);
        //System.out.println(amountMinutesOperator);

        
      
    }
}
