/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class Pino {

    //Atributo
    private int altura;

    //Constructor
    public Pino(int altura) {
        this.altura = altura;
    }

    //Getter
    public int getAltura() {
        return altura;
    }

    //Setter
    public void setAltura(int altura) {
        this.altura = altura;
    }
    //Metodo cortar

    public void Cortar(int index) {
        this.altura -= index;
    }
}
