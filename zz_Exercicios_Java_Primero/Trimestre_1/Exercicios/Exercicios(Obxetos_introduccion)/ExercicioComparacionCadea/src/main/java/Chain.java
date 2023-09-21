/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class Chain {

    private String chain1;
    private String chain2;
    private String chain3;

    //Constructor
    public Chain(String chain1, String chain2, String chain3) {
        this.chain1 = chain1;
        this.chain2 = chain2;
        this.chain3 = chain3;
    }

    //Getters , Setters
    public String getChain1() {
        return chain1;
    }

    public String getChain2() {
        return chain2;
    }

    public String getChain3() {
        return chain3;
    }

    public void setChain1(String chain1) {
        this.chain1 = chain1;
    }

    public void setChain2(String chain2) {
        this.chain2 = chain2;
    }

    public void setChain3(String chain3) {
        this.chain3 = chain3;
    }
    
    //Metodo
    public String maior(){
        String solution;
        if (this.chain1.length() >= this.chain2.length() && this.chain1.length() >= this.chain3.length())
            solution = "A cadea mais larga é a 1";
        else if (this.chain2.length() > this.chain3.length())
            solution = "A cadea mais larga é a 2";
        else
            solution = "A cadeas mais larga é a 3";
        
        return solution;
    }

}
