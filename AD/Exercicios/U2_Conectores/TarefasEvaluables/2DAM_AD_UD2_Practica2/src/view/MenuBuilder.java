
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

    /*

        ---MAIN MENU---

     */
    public void initMainMenu(){

        boolean hasExited = false;
        Scanner reads = new Scanner(System.in);

        do{

            this.cls();
            System.out.println("1-> Employee management");
            System.out.println("2-> Department management");
            System.out.println("3-> Queries");
            System.out.println("0-> Exit");
            System.out.println("Waiting for user input ... ");

            String input = reads.nextLine();

            try{

                hasExited = this.switchMainMenuInput(input);

            }catch(Exception ex){

                System.out.println("[ERROR][initMainMenu()/@switchMainMenuInput]: " + ex.getLocalizedMessage());

            }

        }while(!hasExited);


    }

    private boolean switchMainMenuInput(String inpt){

        switch(inpt){

            case "1":
                this.initEmployeeManagementMenu();
                return false;

            case "2":
                this.initDepartmentManagementMenu();
                return false;

            case "3":
                this.initQueryMenu();
                return false;

            case "0":

                return true;

            default:
                System.out.println(">ERROR: Input invalid");
                return false;

        }

    }

    /*

    ---QUERY MENU---

    */
    public void initQueryMenu(){
        
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

                hasExited = this.switchQueryInput(input);

            } catch (SQLException e) {

                System.out.println("[ERROR][initQueryMenu()/@switchQueryInput]: " + e.getLocalizedMessage());

            }

        }while(!hasExited);
    }
    
    private boolean switchQueryInput(String inpt) throws SQLException {

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

    /*

        ---EMPLOYEE MANAGEMENT MENU---

     */
    public void initEmployeeManagementMenu(){

        boolean hasExited = false;
        Scanner reads = new Scanner(System.in);

        do{
            this.cls();
            System.out.println("a-> Insert new user");
            System.out.println("b-> Modify a user");
            System.out.println("c-> Delete a user");
            System.out.println("0-> Exit");
            System.out.println("Waiting for user input ... ");

            String input = reads.nextLine();

            try {

                hasExited = this.switchEmployeeManagementInput(input);

            } catch (Exception e) {

                System.out.println("[ERROR][initEmployeeManagementMenu()/@switchEmployeeManagementInput]: " + e.getLocalizedMessage());

            }

        }while(!hasExited);

    }
    private boolean switchEmployeeManagementInput(String inpt){

        switch(inpt){

            case "a":

                String nif = this.pedirDni();
                String nss = this.pedirNss();
                String nombre = this.pedirNombre();

                try{

                    this.qh.insertNewEmployee(nss,nombre,nif);

                }catch(SQLException ex){

                    System.out.println(ex.getLocalizedMessage());

                }

                return false;

            case "b":

                return false;

            case "c":

                String nifc = this.pedirDni();

                try{

                    this.qh.deleteEmployee(nifc);

                }catch(SQLException ex){

                    System.out.println(ex.getLocalizedMessage());

                }

                return false;

            case "0":

                return true;

            default:
                System.out.println(">ERROR: Input invalid");
                return false;

        }

    }

    /*

        ---DEPARTMENT MANAGEMENT MENU---

     */
    public void initDepartmentManagementMenu(){

        boolean hasExited = false;
        Scanner reads = new Scanner(System.in);

        do{
            this.cls();
            System.out.println("a-> Insert new department");
            System.out.println("b-> Modify a department");
            System.out.println("c-> Delete a department");
            System.out.println("d-> List all departments");
            System.out.println("i-> Lookup department by name");
            System.out.println("ii-> Lookup department by id");
            System.out.println("0-> Exit");
            System.out.println("Waiting for user input ... ");

            String input = reads.nextLine();

            try {

                hasExited = this.switchDepartmentManagementInput(input);

            } catch (Exception e) {

                System.out.println("[ERROR][initDepartmentManagementMenu()/@switchDepartmentManagementInput]: " + e.getLocalizedMessage());

            }

        }while(!hasExited);

    }

    private boolean switchDepartmentManagementInput(String inpt){

        Scanner reads = new Scanner(System.in);

        switch(inpt){

            case "a":

                String name = this.pedirNombreDep();
                System.out.println("Waiting for numDep ... ");
                int num = reads.nextInt();
                reads.nextLine();

                if(name != ""){

                    try{

                        this.qh.insertNewDepartment(name, num);

                    }catch(SQLException e){

                        System.out.println("[ERROR][switchDepartmentManagementInput()/@optA]: " + e.getLocalizedMessage());

                    }

                }

                return false;

            case "b":
                //TBD
                return false;

            case "c":

                System.out.println("Waiting for Numdep to delete ... ");
                int depnum = reads.nextInt();
                reads.nextLine();

                try{

                    this.qh.deleteDepartment(depnum);

                }catch(SQLException e){

                    System.out.println("[ERROR][switchDepartmentManagementInput()/@optC]: " + e.getLocalizedMessage());

                }

                return false;

            case "d":

                try{

                    String result = this.qh.getQueryAllDepartments();
                    System.out.println(result);

                }catch(SQLException e){

                    System.out.println("[ERROR][switchDepartmentManagementInput()/@optD]: " + e.getLocalizedMessage());

                }

                return false;

            case "i":

                try{

                    String v = this.pedirNombreDep();
                    String res = this.qh.getDepartmentByName(v);
                    System.out.println(res);

                }catch(SQLException e){

                    System.out.println("[ERROR][switchDepartmentManagementInput()/@opti]: " + e.getLocalizedMessage());

                }

                return false;

            case "ii":

                try{

                    System.out.println("Waiting for Numdep to query by ... ");
                    int n = reads.nextInt();
                    reads.nextLine();

                    String r = this.qh.getDepartmentByNum(n);
                    System.out.println(r);

                }catch(SQLException e){

                    System.out.println("[ERROR][switchDepartmentManagementInput()/@optii]: " + e.getLocalizedMessage());

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

    private String pedirNss(){

        Scanner reads = new Scanner(System.in);

        System.out.println(">>[WAITING FOR USER INPUT] NSS ... [<=6]");
        String returnable = reads.nextLine();

        if(returnable.length() <= 6){

            return returnable;

        }else{

            System.out.println("[ERROR][pedirNss()/@returnable<=6]: NSS is too long.");

        }

        return "";

    }

    private String pedirNombre(){

        Scanner reads = new Scanner(System.in);

        System.out.println(">>[WAITING FOR USER INPUT] Name ... [<= 6]");
        String returnable = reads.nextLine();

        if(returnable.length() <= 6){

            return returnable;

        }else{

            System.out.println("[ERROR][pedirNombre()/@returnable<=6]: Name is too long.");

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

    private String pedirNombreDep(){

        Scanner reads = new Scanner(System.in);
        String name = "";

        try{

            System.out.println(">>[WAITING FOR USER INPUT] Department name ... ");
            name = reads.nextLine();

            if(name.length() <= 15){

                return name;

            }else{

                System.out.println("[ERROR][pedirNombreDep()/@stringFormat]: Value may be too long [<=15]");

            }

        }catch(Exception ex){

            System.out.println("[ERROR][pedirNombreDep()/@stringFormat]: Input invalid");

        }

        return "";

    }

    private void cls(){

        for(int i = 0; i<= 5; i++){

            System.out.println();

        }

    }
}
