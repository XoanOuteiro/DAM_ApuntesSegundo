
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22xoanmoj
 */
public class Persoa {
    //Atributes
    private int age;
    private String name;
    private int currentYear;
    
    //Constructor
    public Persoa (){
        askValue();
        
    }
    
    //Getters and Setters
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }
    
    //Methods
    public String futuro(){
        String result;
        int futureAge = (2030 - this.currentYear) + this.age;
        result = "Ola  " + this.name + ", no ano 2030 terás " + futureAge + " anos.";
        return result;
    }
    private void askValue(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Introduza seu nome");
        this.name = reader.nextLine();
        System.out.println("Introduza o ano actual: ");
        this.currentYear = reader.nextInt();
        System.out.println("Introduza a sua idade: ");
        this.age = reader.nextInt();
    }
    
}
