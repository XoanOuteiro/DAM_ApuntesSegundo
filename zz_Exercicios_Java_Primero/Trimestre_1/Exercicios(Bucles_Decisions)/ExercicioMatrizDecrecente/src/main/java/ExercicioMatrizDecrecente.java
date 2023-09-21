/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class ExercicioMatrizDecrecente {

    public static void main(String[] args) {
        
        //Variables
        int valorInicial = 10;
        
        //Dibujador
        for (int y = 0; y < 5 ; y++){  //Y scroller
            
            valorInicial -= y;
            System.out.println("" + "\n");
            
            for(int x = 5; x >= 1 ; x--){   //X scroller
                System.out.print(valorInicial + "\t" );
                valorInicial--;
            }
            
            valorInicial = 10;
            
        }
    }
}
