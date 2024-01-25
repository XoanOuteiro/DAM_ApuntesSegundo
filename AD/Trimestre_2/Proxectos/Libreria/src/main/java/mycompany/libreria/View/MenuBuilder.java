
package mycompany.libreria.View;

import mycompany.libreria.API.Actuator;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author XoanOuteiro
 */
public class MenuBuilder {
    
    private Scanner reads;
    private Actuator act;
    
    public MenuBuilder(){
        
        this.reads = new Scanner(System.in);
        this.act = new Actuator();
        
    }
    
    public void iniciarMenu() {
        String opcion;
        boolean fin = false;
        do {
                System.out.println("\nEscoge una opcion:\n"
                        + "1 -> Inserción\n"
                        + "2 -> Borrado\n"
                        + "3 -> Consultar\n"
                        + "0 -> Salir\n");

                opcion = reads.nextLine();

                switch (opcion) {
                    case "1":

                        iniciarInsercion();
                        break;

                    case "2":

                        iniciarBorrado();
                        break;

                    case "3":

                        iniciarConsulta();
                        break;
                    case "0":

                        fin = true;
                        break;

                    default:

                        System.out.println("Valor introducido no valido.");

                }

        } while (!fin);

        System.out.println("\nFin de la ejecucion");

    }

    private void iniciarInsercion() {
        String opcion;
        boolean fin = false;
        do {
                System.out.println("\nEscoge una opcion:\n"
                        + "1 -> Inserción Autor\n"
                        + "2 -> Insercion Libro\n"
                        + "0 -> Atrás\n");

                opcion = reads.nextLine();

                switch (opcion) {
                    case "1":
                        try {

                            this.solicitateAutor();

                        }catch(InputMismatchException ex){

                            System.out.println(ex.getLocalizedMessage());

                        }
                        break;

                    case "2":
                        try {

                            this.solicitateLibro();

                        }catch(InputMismatchException ex){

                            System.out.println(ex.getLocalizedMessage());

                        }
                        break;
                    case "0":

                        fin = true;
                        break;

                    default:

                        System.out.println("Valor introducido no valido.");

                }

        } while (!fin);
    }

    private void iniciarBorrado() {
        String opcion;
        boolean fin = false;
        do {
                System.out.println("\nEscoge una opcion:\n"
                        + "1 -> Borrado Autor\n"
                        + "2 -> Borrado Libro\n"
                        + "0 -> Atrás\n");

                opcion = reads.nextLine();

                switch (opcion) {
                    case "1":
                        
                        break;

                    case "2":

                        break;
                    case "0":

                        fin = true;
                        break;

                    default:

                        System.out.println("Valor introducido no valido.");

                }

        } while (!fin);
    }

    private void iniciarConsulta() {
        
        String opcion;
        boolean fin = false;
        do {
                System.out.println("\nEscoge una opcion:\n"
                        + "1 -> Por título\n"
                        + "2 -> Por autor\n"
                        + "3 -> Todos los libros\n"
                        + "4 -> Todos los autores\n"
                        + "0 -> Atrás");

                opcion = reads.nextLine();

                switch (opcion) {
                    case "1":
                        
                        break;

                    case "2":

                        break;
                    case "3":
                        
                        break;
                    case "4":
                        
                        break;
                    case "0":
                        
                        fin = true;
                        break;

                    default:

                        System.out.println("Valor introducido no valido.");

                }

        } while (!fin);
    }
    
}
