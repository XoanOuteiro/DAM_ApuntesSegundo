
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Modification, instancing and dataflow restrictor for the menubuilder. Used as
 * singleton
 *
 * @author XoanOuteiro
 */
public class Controller {

    //Instance atributes
    private ArrayList<Paciente> sys;
    private DOMXMLHandler fhandle;

    //Builder methods
    public Controller() throws IOException {

        this.fhandle = new DOMXMLHandler();
        this.sys = fhandle.startFlowSequence();

    }

    public void notifyEnd() {

        try {

            this.fhandle.doPush(sys);

        } catch (IOException ex) {

            System.out.println("Final save failed");

        }

    }

    //Insert methods
    public void addUser(String nif, String nombre,
            String apellidos, String direccion,
            boolean alergia, char tipo) throws InputMismatchException {
        try {
            Paciente p = new Paciente(nif, nombre, apellidos, direccion, alergia, tipo);

            if (this.runCheck(p)) {

                this.sys.add(p);
                this.fhandle.doPush(this.sys);//Force save

            } else {

                throw new InputMismatchException("User requirements not met");

            }

        } catch (Exception ex) { //Possible typing breakage

            throw new InputMismatchException(ex.getLocalizedMessage());

        }

    }

    //Restriction methods
    private boolean runCheck(Paciente p) {

        //System.out.println("ENTERED CHECK");
        
        if (p.getNif().length() == 9 //Check for alergias not needed as only 0 or 1 can be inputed
                && p.getNombre().length() <= 15
                && p.getApellidos().length() <= 25
                && p.getDireccion().length() <= 30) { //Run nif and char check

            //System.out.println("CHECK LENgTH VALID");
            
            if (this.checkNif(p.getNif()) && this.checkType(p.getTipo())) {

                //System.out.println("CHECK TYPINGS VALID");
                
                return true;

            }

        }

        return false;

    }

    private boolean checkType(char c) {

        char[] possible = {'P', 'S'};
        if (this.in(c, possible)) {

            return true;

        } else {

            return false;

        }

    }

    private boolean checkNif(String nif) {

        char[] numValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] n = nif.toCharArray();

        for (int i = 0 ; i < n.length-1; i++) {

            
            if (!(this.in(n[i], numValues))) {

                return false; //One of the values isnt a number

            }

        }

        //System.out.println("Exited for loop on nif check"); 
        
        if (!(this.in(n[8], numValues)) && this.nifNotUsed(nif)) { //if the 9th char is a letter

            //System.out.println("NIF VALID");
            
            return true;

        }

        return false;

    }

    private boolean nifNotUsed(String nif) {

        for (Paciente p : this.sys) {

            if (p.getNif().equals(nif)) {

                return false;

            }

        }

        return true;

    }

    private boolean in(char c, char[] values) {

        for (char check : values) {

            if (check == c) {

                return true;

            }

        }

        return false;

    }

    //Query methods
    public void listAll() {

        for (Paciente p : this.sys) {

            if (!p.getNif().equals("-1")) {

                System.out.println(p.getNombre() + " " + p.getApellidos() + " ||DNI: " + p.getNif());

            }

        }

    }

    public void listAllergyFilter(boolean b) {

        for (Paciente p : this.sys) {

            if (p.isAlergia() == b && !p.getNif().equals("-1")) {

                System.out.println(p.getNombre() + " " + p.getApellidos() + " ||DNI: " + p.getNif());

            }

        }

    }

    public void listInsuranceFilter(char c) {

        for (Paciente p : this.sys) {

            if (p.getTipo() == c && !p.getNif().equals("-1")) {

                System.out.println(p.getNombre() + " " + p.getApellidos() + " ||DNI: " + p.getNif());

            }

        }

    }

    //Submenus
    public void insert() throws InputMismatchException {

        try {

            Scanner reads = new Scanner(System.in);
            System.out.println("Please input: ");
            System.out.println("NIF: ");
            String nif = reads.nextLine();
            System.out.println("NAME: ");
            String name = reads.nextLine();
            System.out.println("SURNAME/S: ");
            String apellidos = reads.nextLine();
            System.out.println("DIR: ");
            String direccion = reads.nextLine();
            System.out.println("We will set your last visit day to none.");
            System.out.println("If you have any allergies: [0 or 1]");
            String readBool = reads.nextLine();
            boolean allergy;
            if (readBool.equals("1")) {

                allergy = true;

            } else {

                allergy = false;

            }
            System.out.println("Your insurance type: ");
            char type = reads.nextLine().charAt(0);

            this.addUser(nif, name, apellidos, direccion, allergy, type);

        } catch (Exception ex) {

            throw new InputMismatchException("Input error, please try again after checking type needs on PDF." + ex.getLocalizedMessage());

        }

    }

    public void dnilookup() {

        Scanner reads = new Scanner(System.in);
        System.out.println("Insert dni to search: ");
        String nif = reads.nextLine();

        this.printDniUser(nif);

    }

    private void printDniUser(String nif) {

        if (!(this.nifNotUsed(nif))) {

            for (Paciente p : this.sys) {

                if (p.getNif().equals(nif) && !p.getNif().equals("-1")) {

                    System.out.println("Paciente: " + p.getNombre());
                    break;

                }

            }

        } else {

            System.out.println("User not found.");

        }
    }

    public void delete() {

        Scanner reads = new Scanner(System.in);
        System.out.println("Insert dni to delete: ");
        String nif = reads.nextLine();

        if (!(this.nifNotUsed(nif))) {

            for (Paciente p : this.sys) {

                if (p.getNif().equals(nif)) {

                    try {

                        p.setNif("-1");
                        this.fhandle.doPush(sys);
                        break;

                    } catch (IOException ex) {
                        throw new InputMismatchException("Error on save of delete");
                    }

                }

            }

        } else {

            System.out.println("User not found.");

        }

    }
}
