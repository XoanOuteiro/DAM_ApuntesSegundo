/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class Circulo {
//Atributos
   private  int radio;

   //Setter
    public void setRadio(int radio) {
        this.radio = radio;
    }
    //Getter
    public int getRadio() {
        return radio;
    }
//Metodos
    public Circulo(int radio) {
        this.radio = radio;
    }
    
   //Exercicio3 
    public void MultiplicaRadio(){
        this.radio *= 2;
    }
}
