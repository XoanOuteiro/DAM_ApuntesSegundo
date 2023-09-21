
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class Listado {
   private int num;
    
    public Listado(int num){
        this.num = num;
    }
    
    public int maior (){
        Scanner reads = new Scanner(System.in);
        System.out.println("Di un numero");
        int max = -2147483648;
        int num;
        
        for( int contador = 0 ; contador <= 10 ; contador ++ ){
            num = reads.nextInt();
            if (num > max)
                max = num;
        }
        return max;
    }
}



