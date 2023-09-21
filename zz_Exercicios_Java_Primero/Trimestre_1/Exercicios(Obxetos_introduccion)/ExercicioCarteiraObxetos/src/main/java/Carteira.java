/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class Carteira {

    //Atributes
    private int balance;
    private boolean hasCard;

    //Construct
    public Carteira(int balance, boolean hasCard) {
        this.balance = balance;
        this.hasCard = hasCard;
    }

    //Getter
    public int getBalance() {
        return this.balance;
    }

    //Setter
    public void setBalance(int balance) {
        this.balance = balance;
    }

    //Getter
    public boolean isHasCard() {
        return hasCard;
    }

    //Methods
    public String checkAvailable() {
        String resultado;
        if (this.balance >= 100) {
            resultado = "Si tes efectivo";
        } else if (hasCard) {
            resultado = "Dirixase ao caixeiro.";
        } else {
            resultado = "Dirixase a sucursal";
        }
        return resultado;
    }
}
