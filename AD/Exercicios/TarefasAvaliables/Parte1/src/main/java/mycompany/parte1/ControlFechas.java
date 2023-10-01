package mycompany.parte1;


import java.time.LocalDate;
import java.util.Scanner;


/**
 *
 * @author XoanOuteiro
 */
public class ControlFechas {

    //Instance atributes
    PersonaFechas pers1;
    PersonaFechas pers2;

    //Initialization methods
    public ControlFechas() {

        this.inputProtocol();
        System.out.println("");
        this.showLessAgedUser();
        System.out.println("");
        this.showAge(this.pers1);
        this.showAge(this.pers2);
    }

    private void inputProtocol() {
        Scanner reads = new Scanner(System.in);

        //Person 1
        System.out.println("Introduza un nome para o usuario 1... ");
        String name = reads.nextLine();
        System.out.println("Introduza a data de nacemento para o usuario " + name + " (formato dd/mm/yyyy)... ");
        String dateAsString = reads.nextLine();
        this.pers1 = new PersonaFechas(name,dateAsString);
        

        //Person 2
        System.out.println("Introduza un nome para o usuario 2... ");
        name = reads.nextLine();
        System.out.println("Introduza a data de nacemento para o usuario " + name + ". Esperando dia...");
        dateAsString = reads.nextLine();
        this.pers2 = new PersonaFechas(name,dateAsString);

    }
    
    private void showLessAgedUser(){
        
        if (pers1.getFechaNac().getTime() < pers2.getFechaNac().getTime()){
            
            System.out.println(this.pers2.getNombre() + " es menor.");
                
        }else if (pers1.getFechaNac().getTime() > pers2.getFechaNac().getTime()){
            
            System.out.println(this.pers1.getNombre() + " es menor.");
            
        }else{
            
            System.out.println("Ambas idades son iguais");
            
        }
        
    }
    
    private void showAge(PersonaFechas p){
        
        LocalDate curdate = LocalDate.now();
        
        if (curdate.getMonthValue() > p.getMes()){
            
            System.out.println(p.getNombre() + " tiene " + (curdate.getYear() - p.getAno()) + " años.");
            
        }else if (curdate.getMonthValue() == p.getMes()){
            
            if(curdate.getDayOfMonth() >= p.getDia()){
                
                System.out.println(p.getNombre() + " tiene " + (curdate.getYear() - p.getAno()) + " años.");
                
            }else{
                
                System.out.println(p.getNombre() + " tiene " + ((curdate.getYear() - p.getAno())-1) + " años.");
                
            }
            
        }else{
            
            System.out.println(p.getNombre() + " tiene " + ((curdate.getYear() - p.getAno())-1) + " años.");
            
        }
        
        
        
    }

}
