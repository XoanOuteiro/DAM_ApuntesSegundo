
import java.util.Arrays;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author a22xoanmoj
 */
public class CalendarioAdvento {

    private final int row = 6;
    private final int col = 4;
    private int[][] calendario = new int[row][col];

    public CalendarioAdvento(boolean alt) {
        if (alt) {
            int dias = 1;
            for (int i = 0; i <= calendario.length - 1; i++) {
                for (int j = 0; j <= calendario[i].length - 1; j++) {
                    this.calendario[i][j] = dias;
                    dias++;
                }

            }
            encherAlt();
        } else {
            System.out.println("a");
            encher();
        }
    }

    public int[][] getCalendario() {
        return calendario;
    }

    private void encherAlt() {
        int random1;
        int random2;
        int temp;

        for (int i = 0; i <= calendario.length - 1; i++) {
            for (int j = 0; j <= calendario[i].length - 1; j++) {
                random1 = (int) Math.floor(Math.random() * (1 - 4 + 1) + 4);
                random2 = (int) Math.floor(Math.random() * (1 - 6 + 1) + 6);

                //SWAP
                temp = calendario[i][j];
                calendario[i][j] = calendario[random2][random1];
                calendario[random2][random1] = temp;

            }
        }
        System.out.println("\t" + "Calendario");
        mostrar_matriz(calendario);
    }

    private void encher() {
        int random1;
        int[] checker = new int[24];
        boolean hasRepeated;
        int contAr = 0;
        
        for (int i = 0; i <= this.calendario.length - 1; i++) {
            for (int j = 0; j <= this.calendario[i].length - 1; j++) {

                do {
                    random1 = (int) Math.floor(Math.random() * (1 - 24 + 1) + 24);
                    hasRepeated = false;
                    
                    for (int cont1 = 0; cont1 <= checker.length -1; cont1++) {
                        if (checker[cont1] != random1) {
                            hasRepeated = false;
                        } else {
                            hasRepeated = true;
                            cont1 = checker.length;
                        }
                    }
                } while (hasRepeated);
                this.calendario[i][j] = random1;
                checker[contAr] = random1;
                contAr++;
            }
        }
        mostrar_matriz(calendario);
        System.out.println(Arrays.toString(checker));
    }

    public void comer(int x) {
        for (int i = 0; i <= calendario.length - 1; i++) {
            for (int j = 0; j <= calendario[i].length - 1; j++) {
                if (this.calendario[i][j] == x) {
                    this.calendario[i][j] = 0;
                }
            }
        }
        mostrar_matriz(calendario);
    }

    public void mostrar_matriz(int[][] matrix) {
        System.out.println("!*>>Target as: \n ");                  //Arrays.toString(this.main_matrix) not working at dm > 1 
        for (int cont1 = 0; cont1 < matrix.length; cont1++) {
            for (int cont2 = 0; cont2 < matrix[0].length; cont2++) {
                System.out.print("\t" + matrix[cont1][cont2]);
            }
            System.out.println("\n");
        }
    }
}
