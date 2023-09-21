
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class Estatistica {
    int[] main_array = new int[10];
    
    public Estatistica(){
        _introducir_notas();
    }

    public int[] getMain_array() {
        return main_array;
    }

    public void setMain_array(int[] main_array) {
        this.main_array = main_array;
    }
    
     private void _introducir_notas() {
        Scanner reads = new Scanner(System.in);
        for (int i = 0 ; i <= 9 ; i++) {
            this.main_array[i] = reads.nextInt();
        }
    }
}
