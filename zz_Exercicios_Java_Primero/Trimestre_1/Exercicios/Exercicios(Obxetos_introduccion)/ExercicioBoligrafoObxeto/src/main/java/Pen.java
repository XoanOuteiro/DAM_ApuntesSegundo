/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class Pen {

    //Atributes
    private int ink;

    //Getter
    public int getInk() {
        return ink;
    }
//Setter

    public void setInk(int ink) {
        this.ink = ink;
    }

    //Construct
    public Pen() {
        this.ink = 30;
    }

    //Methods
    public String writeAmountOfWords(int amountOfWords) {
        String result;
        if (ink >= amountOfWords) {
            ink -= amountOfWords;
            result = amountOfWords + " Words written.";
        } else {
            result = "No ink left";
        }
        return result;
    }

}
