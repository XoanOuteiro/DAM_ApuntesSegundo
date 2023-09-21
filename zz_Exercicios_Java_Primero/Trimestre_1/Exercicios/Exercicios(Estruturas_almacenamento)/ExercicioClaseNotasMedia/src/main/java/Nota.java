
import java.util.Scanner;
import java.util.stream.IntStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author a22xoanmoj
 */
public class Nota {

    private int[] notas = new int[10];

    public Nota() {
        _introducir_notas();
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }

    private void _introducir_notas() {
        Scanner reads = new Scanner(System.in);
        for (int i = 0 ; i <= 9 ; i++) {
            this.notas[i] = reads.nextInt();
        }
    }

    public int _calcular_media() {
        int result = IntStream.of(this.getNotas()).sum();
        result = result / notas.length;
        return result;
    }
}


