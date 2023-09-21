/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class Bacteria {

    int velocidad;
    int hambre;
    int posicion;

    public Bacteria(int velocidad, int hambre) {
        this.velocidad = velocidad;
        this.hambre = hambre;
        this.posicion = 0;
    }

    public int movimiento() {
        this.posicion += this.velocidad;
        return posicion;
    }

    public void alimentacion() {
        this.hambre -= 20;
    }

}
