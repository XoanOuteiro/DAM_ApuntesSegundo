
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author a22xoanmoj
 */
public class Matriz {

    //Atributes
    private int[][] main_matrix = new int[3][3];

    //Constructor
    public Matriz() {
        define_matrix();
    }
    
    public Matriz(int[][] none){
        this.main_matrix = none;
    }
    
    public Matriz (boolean porDefecto){
        if (porDefecto)
             define_matrix_alt();
        else
           define_matrix(); 
    }

    //getters & setters
    public int[][] getMain_matrix() {
        return main_matrix;
    }

    public void setMain_matrix(int[][] main_matrix) {
        this.main_matrix = main_matrix;
    }

    //Methods
    private void define_matrix() {
        Scanner reads = new Scanner(System.in);
        for (int cont1 = 0; cont1 < this.main_matrix.length; cont1++) {
            for (int cont2 = 0; cont2 < this.main_matrix[0].length; cont2++) {
                System.out.println(">>Waiting for: value at [" + cont1 + ", " + cont2 + "]");
                this.main_matrix[cont1][cont2] = reads.nextInt();
            }
        }
        mostrar_matriz(this.main_matrix);
    }
    
    private void define_matrix_alt(){
        for (int cont1 = 0; cont1 < this.main_matrix.length; cont1++) {
            for (int cont2 = 0; cont2 < this.main_matrix[0].length; cont2++) {
                System.out.println(">>Value automatically set for [" + cont1 + ", " + cont2 + "]");
                this.main_matrix[cont1][cont2] = cont1+cont2+2;
            }
        }
        mostrar_matriz(this.main_matrix);
    }

    public Matriz sumar_matriz(Matriz o) {
        
        int array[][] = new int[3][3];
        
        for (int cont1 = 0; cont1 < this.main_matrix.length; cont1++) {
            for (int cont2 = 0; cont2 < this.main_matrix[0].length; cont2++) {
                array[cont1][cont2] = this.main_matrix[cont1][cont2] + o.main_matrix[cont1][cont2] ;
            }
            
        }
        Matriz dev = new Matriz(array);
        
        return dev; 
    }
    
    public Matriz restar_matriz(Matriz o) {
        
        int array[][] = new int[3][3];
        
        for (int cont1 = 0; cont1 < this.main_matrix.length; cont1++) {
            for (int cont2 = 0; cont2 < this.main_matrix[0].length; cont2++) {
                array[cont1][cont2] = this.main_matrix[cont1][cont2] - o.main_matrix[cont1][cont2] ;
            }
            
        }
        Matriz dev = new Matriz(array);
        
        return dev; 
    }
    
    public void mostrar_matriz(int[][] matrix){
        System.out.println("!*>>Target as: \n ");                  //Arrays.toString(this.main_matrix) not working at dm > 1 
        for (int cont1 = 0; cont1 < matrix.length; cont1++) {
            for (int cont2 = 0; cont2 < matrix[0].length; cont2++) {
                System.out.print("\t" + matrix[cont1][cont2]);
            }
            System.out.println("\n");
        }
    }
    
}
