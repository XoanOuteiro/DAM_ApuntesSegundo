
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * User CLI-GUI for controlled access
 *
 * @author XoanOuteiro
 */
public class MenuBuilder {

    //Instance methods
    private Controller crt;

    //Builder methods
    public MenuBuilder() {

        try {
            
            System.out.println("Instancing menu ... ");
            System.out.println("Instancing new controller");
            this.crt = new Controller();
            System.out.println("Inits succesful.");
            this.cll();
            this.startMainMenu();
            
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());;
        }

    }

    //Menus
    private void startMainMenu() {

        Scanner reads = new Scanner(System.in);

        boolean hasExited = false;

        do {

            this.cll();

            System.out.println("Select option: ");
            System.out.println("1 -> Insert user ");
            System.out.println("2 -> Delete user ");
            System.out.println("3 -> Search a user ");
            System.out.println("4 -> Queries ");
            System.out.println("0 -> Save and exit ");

            String opt = reads.nextLine();

            hasExited = switchOptions(opt);

        } while (!hasExited);

    }

    private boolean switchOptions(String opt) {

        switch (opt) {

            case "1":

                try {

                this.crt.insert();
                return false;

            } catch (InputMismatchException ex) {

                System.out.println(ex.getLocalizedMessage());
                return false;

            }

            case "2":

                try {

                this.crt.delete();
                return false;

            } catch (Exception ex) {

                System.out.println(ex.getLocalizedMessage());
                return false;

            }

            case "3":

                try {

                this.crt.dnilookup();
                return false;

            } catch (Exception ex) {

                System.out.println(ex.getLocalizedMessage());
                return false;

            }

            case "4":

                try {

                this.openSubqueryMenu();
                return false;

            } catch (Exception ex) {

                System.out.println(ex.getLocalizedMessage());
                return false;

            }

            case "0":

                try {

                this.crt.notifyEnd();

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

    private void openSubqueryMenu() {

        Scanner reads = new Scanner(System.in);

        boolean hasExited = false;

        do {

            this.cll();

            System.out.println("Select option: ");
            System.out.println("1 -> Absolute ");
            System.out.println("2 -> Allergy filter ");
            System.out.println("3 -> Insurance filter ");

            String opt = reads.nextLine();

            hasExited = switchSubqueryOptions(opt);

        } while (!hasExited);

    }

    private boolean switchSubqueryOptions(String opt) {

        Scanner reads = new Scanner(System.in);

        switch (opt) {

            case "1":

                try {

                this.crt.listAll();
                return true;

            } catch (InputMismatchException ex) {

                System.out.println(ex.getLocalizedMessage());
                return true;

            }

            case "2":

                try {

                boolean picked = false;
                do {

                    System.out.println("1- To list users with allergy");
                    System.out.println("0-To list users without allergy");
                    String choice = reads.nextLine();

                    switch (choice) {

                        case "1":
                            this.crt.listAllergyFilter(true);
                            picked = true;
                            break;

                        case "0":
                            this.crt.listAllergyFilter(false);
                            picked = true;
                            break;

                        default:
                            System.out.println("Option not valid, try again.");
                            break;

                    }

                } while (!picked);

                return false;

            } catch (Exception ex) {

                System.out.println(ex.getLocalizedMessage());
                return false;

            }

            case "3":

                try {

                boolean picked = false;
                do {

                    System.out.println("1- To list users with private insurance");
                    System.out.println("0-To list users with social insurance");
                    String choice = reads.nextLine();

                    switch (choice) {

                        case "1":
                            this.crt.listInsuranceFilter('P');
                            picked = true;
                            break;

                        case "0":
                            this.crt.listInsuranceFilter('S');
                            picked = true;
                            break;

                        default:
                            System.out.println("Option not valid, try again.");
                            break;

                    }

                } while (!picked);
                return false;

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
    private void cll() {

        for (int i = 0; i < 5; i++) {

            System.out.println("");

        }

    }
}
