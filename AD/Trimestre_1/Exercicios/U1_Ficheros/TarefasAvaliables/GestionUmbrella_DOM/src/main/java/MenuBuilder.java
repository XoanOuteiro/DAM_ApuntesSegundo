import Data.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author XoanOuteiro
 */
public class MenuBuilder {

    Controller ctr;

    public MenuBuilder(){

        System.out.println("Instancing menu ... ");
        System.out.println("Instancing new controller");
        this.ctr = new Controller();
        System.out.println("Inits succesful.");
        this.cll();
        this.startMainMenu();

    }

    //Menus
    private void startMainMenu(){

        Scanner reads = new Scanner(System.in);

        boolean hasExited = false;

        do{

            this.cll();

            System.out.println("Select option: ");
            System.out.println("1 -> Insert user ");
            System.out.println("2 -> Modify user ");
            System.out.println("3 -> Delete user ");
            System.out.println("4 -> Search a user ");
            System.out.println("5 -> List all user ");
            System.out.println("0 -> Save and exit ");

            String opt = reads.nextLine();

            hasExited = switchOptions(opt);

        }while(!hasExited);

    }

    private boolean switchOptions(String opt){

        switch (opt) {

            case "1":

                try {

                    this.ctr.insercion();
                    return false;

                } catch (InputMismatchException ex) {

                        System.out.println(ex.getLocalizedMessage());
                        return false;

                }

            case "2":

                try {

                    this.ctr.modificacion();
                    return false;

                } catch (Exception ex) {

                    System.out.println(ex.getLocalizedMessage());
                    return false;

                }

            case "3":

                try {

                    this.ctr.borrado();
                    return false;

                } catch (Exception ex) {

                    System.out.println(ex.getLocalizedMessage());
                    return false;

                }

            case "4":

                try {

                    this.ctr.consulta();
                    return false;

                } catch (Exception ex) {

                    System.out.println(ex.getLocalizedMessage());
                    return false;

                }

            case "5":

                try {

                    this.ctr.listar();
                    return false;

                } catch (Exception ex) {

                    System.out.println(ex.getLocalizedMessage());
                    return false;

                }

            case "0":

                try {

                    this.ctr.attemptSave();

                    return true;

                } catch (Exception ex) {

                    System.out.println(ex.getLocalizedMessage());
                    return false;

                }

            default:

                System.out.println("Option not valid");
                return false;

        }
    }

    //Cleanup methods
    private void cll(){

        for (int i = 0; i < 5 ; i++){

            System.out.println("");

        }

    }

}
