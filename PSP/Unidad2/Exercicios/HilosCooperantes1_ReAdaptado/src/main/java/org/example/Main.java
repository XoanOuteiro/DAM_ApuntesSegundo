package org.example;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        /*
        
        ADAPTACIONES:
        
        En vez de String[] se añaden personas                                               (hecho)
        En vez de ArrayList<String[]> se usa LinkedList<Persona>                            (hecho)
        La busqueda de valores esta sincronizada                                            (hecho)
        Los archivos se reciben por args y se envian en el constructor de ThreadManager     
        El resultado se vuelca en un archivo
        
        */
        ThreadManager th = new ThreadManager();

        try{

            th.setupThreads(th.getFiles());

            if(th.startProcess()){

                System.out.println(th.getString());

            }else{

                System.out.println("!> ERROR en la inicialización del proceso.");

            }

        }catch(FileNotFoundException ex){

            System.out.println("!> ERROR: El archivo no es alcanzable.");

        }




    }
}