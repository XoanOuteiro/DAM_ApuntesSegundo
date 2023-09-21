/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 * 
 */
import java.util.Scanner;

public class Partida {

    //Atributos
    private int randNum;        //Numero a adiviñar, non interactuable
    private int numMin;         //Numero minimo do abanico, interactuable
    private int numMax;        //Numero maximo do abanico, interactuable
    private int turnChoice;     //Cantidade de intentos, interactuable

    //Constructor
    public Partida(int numMin, int numMax, int turnChoice) {
        this.numMin = numMin;
        this.numMax = numMax;
        this.turnChoice = turnChoice;
        this.randNum = (int) Math.floor(Math.random() * (numMin - numMax + 1) + numMax);
    }

    //Getter e Setters
    public int getRandNum() {
        return randNum;
    }

    public int getNumMin() {
        return numMin;
    }

    public int getNumMax() {
        return numMax;
    }

    public int getTurnChoice() {
        return turnChoice;
    }

    public void setRandNum(int randNum) {
        this.randNum = randNum;
    }

    public void setNumMin(int numMin) {
        this.numMin = numMin;
    }

    public void setNumMax(int numMax) {
        this.numMax = numMax;
    }

    public void setTurnChoice(int turnChoice) {
        this.turnChoice = turnChoice;
    }

    //Metodos
    public boolean checkNum(int inputsNum) {

        boolean hasWon = true;
        //System.out.println(randNum);

        //Game check
        if (inputsNum > randNum) {
            System.out.println("O numero e menor ca o escrito");
            hasWon = false;

        } else if (randNum > inputsNum) {
            System.out.println("O numero e maior ca o escrito");
            hasWon = false;
        }
        if (randNum == inputsNum) {
            hasWon = true;
        }
        //Main check
        if (hasWon == true) {
            this.turnChoice = 0;
        }
        return hasWon;
    }

    public void turnRunner() {
        boolean checksWin = false;

        for (int turn = 1; turn <= this.turnChoice; turn++) {

            System.out.println("Levas " + turn + "/" + turnChoice + " turnos.");

            Scanner reads = new Scanner(System.in);
            int checksFor = reads.nextInt();

            checkNum(checksFor);
            checksWin = checkNum(checksFor);
        }
        if (checksWin) {
            System.out.println("Ganaches");
        } else {
            System.out.println("Perdiches");

        }

    }

}
