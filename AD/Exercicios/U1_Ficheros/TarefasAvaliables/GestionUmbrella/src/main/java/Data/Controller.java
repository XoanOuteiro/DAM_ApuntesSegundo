package Data;

import Model.Empleado;

import java.io.IOException;
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

        try {

            this.dth = new DataHandler();

            this.sys = this.dth.doImportSequence();

        }catch (IOException ex){

            System.out.println("Output file not found. ");

        }

    }

    //Instance methods
    public void insercion() throws InputMismatchException {
        /*
            Software instruction requires that data is retrieved here.
            This is not the recommended design pattern
         */
        float salary;

        Scanner reads = new Scanner(System.in);
        
        String nif = this.askForDni();

        if (nif != null && checkUnused(nif)) {

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

                //Ex 1 save
                this.attemptSave();


            } else {
                
                throw new InputMismatchException("Name or surname too long.");
                
            }

        } else {

            throw new InputMismatchException("NIF was already used or invalid.");

        }

    }

    public void borrado() throws NullPointerException {

        String nif = this.askForDni();

        if(nif != null) {

            Empleado e = this.getUserByNif(nif);

            if (e != null) {

                e.setNif("-1");
                System.out.println("user deleted.");

                //Ex 1 save
                this.attemptSave();

            } else {

                throw new NullPointerException("User not found.");

            }

        } else {

            throw new NullPointerException("User not found.");

        }
    }

    public void listar(){

        for(Empleado e : this.sys){

            if(!(e.getNif().equals("-1"))){

                System.out.println("Nif: " + e.getNif() + "\t Name: " + e.getNombre() +"\t Surname: " + e.getApellidos() + "\t Salary: " + e.getSalario());

            }
        }
    }

    public void modificacion() throws NullPointerException, InputMismatchException{

        Scanner reads = new Scanner(System.in);

        String nif = this.askForDni();

        if(nif != null) {

            Empleado e = this.getUserByNif(nif);

            if (e != null) {

                System.out.println("Input new salary for user " + e.getNombre() + " ... ");
                try {

                    float salary = reads.nextFloat();
                    reads.nextLine(); //Flush buffer

                    e.setSalario(salary);

                    //Ex 1 save
                    this.attemptSave();

                } catch (Exception error) {

                    throw new InputMismatchException("Salary value invalid");

                }

            } else {

                throw new NullPointerException("Users NIF does not exist.");

            }

        } else {

            throw new NullPointerException("User not found");

        }
    }

    public void consulta() throws NullPointerException{

        Scanner reads = new Scanner(System.in);

        String nif = this.askForDni();

        if(nif != null) {

            Empleado e = this.getUserByNif(nif);

            if (e != null) {

                System.out.println("Nif: " + e.getNif() + "\t Name: " + e.getNombre() + "\t Surname: " + e.getApellidos() + "\t Salary: " + e.getSalario());

            } else {

                throw new NullPointerException("User not found");

            }

        } else {

            throw new NullPointerException("User not found.");

        }

    }

    //Own methods
    public void attemptSave(){

        try{

            this.dth.outputSavestate(this.sys);

        }catch(IOException ex){

            System.out.println("ERROR: Init was ignored so state isn't being saved. Please restart your program as admin.");

        }

    }

    private boolean checkUnused(String n) {

        for (Empleado e : sys) {

            if (e.getNif().equals(n)) {

                return false;

            }

        }

        return true;

    }

    private Empleado getUserByNif(String nif){

        for(Empleado e : this.sys){

            if(e.getNif().equals(nif)){

                return e;

            }

        }

        return null;

    }

    private String askForDni(){

        Scanner reads = new Scanner(System.in);
        System.out.println("Input user NIF ... ");
        String nif = reads.nextLine();

        if(nif.length() == 9 && !(nif.equals("-1"))){

            return nif;

        } else {

            return null;

        }
    }


}
