package Data;

import Model.Empleado;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * Creates an interface that allows the MenuBuilder to access a System
 * simulatory file holding an employee list
 *
 * @author XoanOuteiro
 */
public class Controller {

    //Instance atributes
    private ArrayList<Empleado> sys;    //File contents
    private DataHandler dth;

    //Builder methods
    public Controller() {

        this.dth = new DataHandler();

        this.sys = dth.doImport();

    }

    //Instance methods
    public void insercion() throws InputMismatchException {
        /*
            Software instruction requires that data is retrieved here.
            This is not the recommended design pattern
         */
        float salary;
        
        Scanner reads = new Scanner(System.in);
        System.out.println("Input user NIF ... ");
        String nif = reads.nextLine();

        if (nif.length() == 9 && checkUnused(nif)) {

            System.out.println("Input employee name ... ");
            String name = reads.nextLine();

            System.out.println("Input employee surname ... ");
            String surname = reads.nextLine();

            try {
                
                System.out.println("Input employee salary ... ");
                salary = reads.nextFloat();
                reads.nextLine();   //Buffer flush
                
            } catch (Exception e) {
                
                throw new InputMismatchException("Input invalid");
                
            }

            if (name.length() <= 10 && surname.length() <= 20) {

                this.sys.add(new Empleado(nif, name, surname,salary));

            } else {
                
                throw new InputMismatchException("Name or surname too long.");
                
            }

        } else {

            throw new InputMismatchException("NIF was already used or invalid.");

        }

    }

    public void listar(){

        for(Empleado e : this.sys){

            if(!(e.getNif().equals("-1"))){

                System.out.println("Nif: " + e.getNif() + "\t Name: " + e.getNombre() +"\t Surname: " + e.getApellidos() + "\t Salary: " + e.getSalario());

            }
        }

    }

    //Own methods
    private boolean checkUnused(String n) {

        for (Empleado e : sys) {

            if (e.getNif().equals(n)) {
                return false;
            }

        }

        return true;

    }
}
