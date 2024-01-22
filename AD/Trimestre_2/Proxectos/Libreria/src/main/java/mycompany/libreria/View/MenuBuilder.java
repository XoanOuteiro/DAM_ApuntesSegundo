
package mycompany.libreria.View;

import java.util.Scanner;

/**
 *
 * @author XoanOuteiro
 */
public class MenuBuilder {
    
    private Scanner reads;
    
    public MenuBuilder(){
        
        this.reads = new Scanner(System.in);
        
    }
    
    public void iniciarMenu() {
        String opcion;
        boolean fin = false;
        do {
                System.out.println("\nEscoge una opcion:\n"
                        + "1 -> Inserción\n"
                        + "2 -> Borrado\n"
                        + "3 -> Consultar\n"
                        + "4 -> Salir\n");

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
                    case "4":

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
                        + "3 -> Atrás\n");

                opcion = reads.nextLine();

                switch (opcion) {
                    case "1":
                        
                        break;

                    case "2":

                        break;
                    case "3":

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
                        + "3 -> Atrás\n");

                opcion = reads.nextLine();

                switch (opcion) {
                    case "1":
                        
                        break;

                    case "2":

                        break;
                    case "3":

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
                        + "5 -> Atrás");

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
                    case "5":
                        
                        fin = true;
                        break;

                    default:

                        System.out.println("Valor introducido no valido.");

                }

        } while (!fin);
    }
    
}
