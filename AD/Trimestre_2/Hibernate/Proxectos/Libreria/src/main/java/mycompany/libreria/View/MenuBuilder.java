
package mycompany.libreria.View;

import mycompany.libreria.API.Actuator;
import mycompany.libreria.Controller_Model.Autor;
import mycompany.libreria.Controller_Model.Libro;
import mycompany.libreria.Controller_Model.Telefono;

import java.util.ArrayList;
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
        this.act.endSession();

    }

    private void iniciarInsercion() {
        String opcion;
        boolean fin = false;
        do {
                System.out.println("\nEscoge una opcion:\n"
                        + "1 -> Inserción Autor\n"
                        + "2 -> Insercion Libro\n"
                        + "3 -> Asociar telefono a Autor\n"
                        + "0 -> Atrás\n");

                opcion = reads.nextLine();

                switch (opcion) {
                    case "1":
                        try {

                            this.insertAutor();

                        }catch(InputMismatchException ex){

                            System.out.println(ex.getLocalizedMessage());

                        }
                        break;

                    case "2":
                        try {

                            this.insertLibro();

                        }catch(InputMismatchException ex){

                            System.out.println(ex.getLocalizedMessage());

                        }
                        break;

                    case "3":
                        try{

                            System.out.println(">>Waiting for [DNI_AUTOR] ... ");
                            String dni = reads.nextLine();

                            System.out.println(">>Waiting for [TEL_NUM] ... ");
                            String telf = reads.nextLine();

                            Autor a = this.act.getAutorByDNI(dni);
                            Telefono tel = new Telefono(a,telf);

                            this.act.insert(tel);

                        }catch(Exception ex){

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

                        try{

                            System.out.println(">>Waiting for [DNI_AUTOR] ... ");
                            String dniAutor = reads.nextLine();

                            Autor a = this.act.getAutorByDNI(dniAutor);
                            this.act.delete(a);

                        }catch(InputMismatchException ex){

                            System.out.println(ex.getLocalizedMessage());

                        }

                        break;

                    case "2":

                        try{

                            System.out.println(">>Waiting for [ID_LIBRO] ... ");
                            int idLibro = reads.nextInt(); reads.nextLine();

                            Libro a = this.act.getLibroByID(idLibro);
                            this.act.delete(a);

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

    private void iniciarConsulta() {
        
        String opcion;
        boolean fin = false;
        do {
                System.out.println("\nEscoge una opcion:\n"
                        + "1 -> Por título\n"
                        + "2 -> Por autor\n"
                        + "3 -> Todos los libros\n"
                        + "4 -> Todos los autores con sus libros\n"
                        + "0 -> Atrás");

                opcion = reads.nextLine();

                switch (opcion) {
                    case "1":

                        try{

                            System.out.println("Waiting for [BOOK_TITLE] ... ");
                            String titulo = reads.nextLine();
                            Libro l = this.act.getLibroByTitle(titulo);

                            if (l != null) {

                                System.out.println(l.toString());

                            }else{

                                System.out.println(">>Ese libro no existe.");

                            }


                        }catch(Exception ex){

                            System.out.println(ex.getLocalizedMessage());

                        }

                        break;

                    case "2":

                        try{

                            System.out.println("Waiting for [AUTHOR_NAME] ... ");
                            String name = reads.nextLine();
                            Autor atr = this.act.getAutorByName(name);
                            ArrayList<Libro> l = this.act.getLibroByAutor(atr);

                            printListLibros(l);


                        }catch(Exception ex){

                            System.out.println(ex.getLocalizedMessage());

                        }

                        break;
                    case "3":

                        try{

                            ArrayList<Libro> l = this.act.getLibros();

                            printListLibros(l);


                        }catch(Exception ex){

                            System.out.println(ex.getLocalizedMessage());

                        }

                        break;
                    case "4":

                        try{

                            ArrayList<Autor> autores = this.act.getAutors();

                            for(Autor a : autores){

                                ArrayList<Libro> libros = this.act.getLibroByAutor(a);

                                printListLibros(libros);

                            }

                        }catch(Exception ex){

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

    private static void printListLibros(ArrayList<Libro> l) {
        if(l != null) {

            for (Libro libro : l) {

                System.out.println(libro.toString());

            }

        }
    }

    /*

        ---Private requests methods

     */
    private void insertAutor(){

        try{

            System.out.println(">>Waiting for [DNI_AUTOR] ... ");
            String dni = reads.nextLine();
            System.out.println(">>Waiting for [NOMBRE] ... ");
            String nombre = reads.nextLine();
            System.out.println(">>Waiting for [NACIONALIDAD] ... ");
            String nacionalidad = reads.nextLine();

            this.act.insert(new Autor(dni,nombre,nacionalidad));


        }catch(Exception ex){

            throw new InputMismatchException("ERROR: Valores invalidos : " + ex.getLocalizedMessage());

        }

    }
    
    private void insertLibro(){

        try{

            System.out.println(">>Waiting for [TITULO] ... ");
            String titulo = reads.nextLine();
            System.out.println(">>Waiting for [PRECIO] ... ");
            float precio = reads.nextFloat();reads.nextLine();
            System.out.println(">>Waiting for [DNI_AUTOR] ... ");
            String dniAutor = reads.nextLine();
            Autor autor = this.act.getAutorByDNI(dniAutor);

            if(autor != null) {

                this.act.insert(new Libro(titulo, precio, autor));

            }else{

                throw new InputMismatchException("Ese autor no existe.");

            }

        }catch(Exception ex){

            throw new InputMismatchException("ERROR: Valores invalidos : " + ex.getLocalizedMessage());

        }
        
    }
}
