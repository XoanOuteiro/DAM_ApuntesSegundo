
package view;

import controller.QueryHandler;

import javax.management.Query;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author XoanOuteiro
 * 
 */
public class MenuBuilder {
    
    private QueryHandler qh;

    public MenuBuilder(){

        try {

            this.qh = new QueryHandler();


        } catch (Exception e) {

            System.out.println("[ERROR][MenuBuilder()/@switchInput]: " + e.getLocalizedMessage());

        }

        this.initMainMenu();

    }
    
    public void initMainMenu(){
        
        boolean hasExited = false;
        Scanner reads = new Scanner(System.in); 
        
        do{
            this.cls();
            System.out.println("1-> Query all users");
            System.out.println("2-> Query users by DNI/NIF");
            System.out.println("3-> Query users by salary (> than input)");
            System.out.println("4-> Query users by salary (<= than input)");
            System.out.println("0-> Exit");
            System.out.println("Waiting for user input ... ");
            
            String input = reads.nextLine();

            try {

                hasExited = this.switchInput(input);

            } catch (SQLException e) {

                System.out.println("[ERROR][initMainMenu()/@switchInput]: " + e.getLocalizedMessage());

            }

        }while(!hasExited);
    }
    
    private boolean switchInput(String inpt) throws SQLException {

        switch(inpt){

            case "1":
                System.out.println(this.qh.getQueryAll());
                return false;

            case "2":

                String dni = this.pedirDni();
                System.out.println(this.qh.getQueryByNif(dni));
                return false;

            case "3":

                int gsalary = this.pedirSalario();
                if(gsalary != -1) {

                    System.out.println(this.qh.getQueryByGreaterThanSalary(gsalary));

                }
                return false;

            case "4":

                int lsalary = this.pedirSalario();
                if(lsalary != -1) {

                    System.out.println(this.qh.getQueryByLesserThanSalary(lsalary));

                }
                return false;

            case "0":

                return true;

            default:
                System.out.println(">ERROR: Input invalid");
                return false;

        }
        
    }

    //Request to user methods
    private String pedirDni(){

        Scanner reads = new Scanner(System.in);

        System.out.println(">>[WAITING FOR USER INPUT] Nif ... ");
        String returnable = reads.nextLine();

        if(returnable.length() <= 45){
            
            return returnable;

        }else{

            System.out.println("[ERROR][pedirDni()/@returnable<=45]: DNI is too long.");

        }

        return "";

    }

    private int pedirSalario(){

        Scanner reads = new Scanner(System.in);
        int value = 0;

        System.out.println(">>[WAITING FOR USER INPUT] Salary ... ");

        try{

            value = reads.nextInt();
            reads.nextLine(); //Buffer flush
            return value;

        }catch(Exception ex){

            System.out.println("[ERROR][pedirSalario()/@numberFormat]: Value cannot be parsed to number");

        }

        return -1;

    }

    private void cls(){

        for(int i = 0; i<= 5; i++){

            System.out.println();

        }

    }
}
