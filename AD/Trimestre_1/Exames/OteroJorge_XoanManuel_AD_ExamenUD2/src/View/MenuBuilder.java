package View;

import Controller.DataHandler;
import Validators.Validator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author a22xoanmoj
 */
public class MenuBuilder {

    private Validator v;
    private DataHandler dh;

    public MenuBuilder() {

        try {

            this.v = new Validator();
            this.dh = new DataHandler();

        } catch (Exception e) {

            System.out.println(e);

        }

        this.initMainMenu();

    }

    public void initMainMenu() {

        boolean hasExited = false;
        Scanner reads = new Scanner(System.in);

        do {

            this.cls();
            System.out.println("1-> List employees");
            System.out.println("2-> Get employee data by NIF");
            System.out.println("3-> Insert new employee");
            System.out.println("4-> Modify employee");
            System.out.println("5-> Get employees with less salary than");
            System.out.println("0-> Exit");
            System.out.println("Waiting for user input ... ");

            String input = reads.nextLine();

            try {

                hasExited = this.switchMainMenuInput(input);

            } catch (Exception ex) {

                System.out.println("[ERROR][initMainMenu()/@switchMainMenuInput]: " + ex.getLocalizedMessage() + " " + ex.getClass());

            }

        } while (!hasExited);

    }

    private boolean switchMainMenuInput(String i) {
        
        switch (i) {

            case "1":

                try {

                    String result = this.dh.listarEmpleados();
                    System.out.println(result);

                } catch (SQLException e) {

                    System.out.println(e.getLocalizedMessage());

                }

            return false;

            case "2":

                try {

                    String nif = this.solicitateNIF();
                    
                    if(!(nif.equals(""))){
                    
                        String result = this.dh.datosEmpleadoNIF(nif);
                        System.out.println(result);
                        
                    }else{
                        
                        System.out.println("NIF format not valid.");
                        
                    }

                } catch (SQLException | ArrayIndexOutOfBoundsException e) {

                    System.out.println("NIF format not valid.");

                }

            return false;

            case "3":

                try{
                    
                    String nif = this.solicitateNIF();
                    String nombre = this.solicitateName();
                    String apellidos = this.solicitateApellidos();
                    Float salary = this.solicitateSalary();
                    
                    if(!(nif.equals("") || nombre.equals("") || apellidos.equals("") || salary == -1f)){
                        
                        String s = this.dh.insertarEmpleados(nif, nombre, apellidos, salary);
                        System.out.println(s);
                        
                    }else{
                        
                        System.out.println("Data not valid for insert.");
                        
                    }
                    
                }catch(Exception e){
                    
                    System.out.println(e.getLocalizedMessage());
                    
                }
                
                return false;

            case "4":
                
                try{
                    
                    String nif = this.solicitateNIF();
                    Float salary = this.solicitateSalary();
                    
                    if(!(nif.equals("") || salary == -1f)){
                        
                        String s = this.dh.modificarSalarioEmpleado(nif, salary);
                        System.out.println(s);
                        
                    }else{
                        
                        System.out.println("Data not valid for update.");
                        
                    }
                    
                }catch(Exception e){
                    
                    System.out.println(e.getLocalizedMessage());
                    
                }

                return false;

            case "5":
                
                try{
                    
                    Float salary = this.solicitateSalary();
                    
                    if(!(salary == -1f)){
                        
                        String result = this.dh.empleadosSalarioMenor(salary);
                        System.out.println(result);
                        
                    }else{
                        
                        System.out.println("Data not valid for query.");
                        
                    }
                    
                }catch(Exception e){
                    
                    System.out.println(e.getLocalizedMessage());
                    
                }

                return false;

            case "0":

                return true;

            default:
                System.out.println("Input invalid");
                return false;

        }

    }

    //Private utility
    private void cls() {

        for (int i = 0; i <= 5; i++) {

            System.out.println();

        }

    }

    private String solicitateNIF() {

        Scanner reads = new Scanner(System.in);
        System.out.println("Waiting for user input: NIF ... ");
        String nif = reads.nextLine();

        if (v.checkNif(nif)) {

            return nif;

        } else {

            return "";

        }
    }

    private String solicitateName() {

        Scanner reads = new Scanner(System.in);
        System.out.println("Waiting for user input: Name ... ");
        String name = reads.nextLine();

        if (v.hasLength(name, 100)) {

            return name;

        } else {

            return "";

        }

    }

    private String solicitateApellidos() {

        Scanner reads = new Scanner(System.in);
        System.out.println("Waiting for user input: Surname ... ");
        String surname = reads.nextLine();

        if (v.hasLength(surname, 100)) {

            return surname;

        } else {

            return "";

        }

    }

    private Float solicitateSalary() {

        Scanner reads = new Scanner(System.in);
        System.out.println("Waiting for user input: Salary ... ");
        String salary = reads.nextLine();

        try {

            float returnable = v.parseDataFloat(salary);
            return returnable;

        } catch (InputMismatchException e) {

            System.out.println(e.getLocalizedMessage());
            return -1f;

        }

    }

}
