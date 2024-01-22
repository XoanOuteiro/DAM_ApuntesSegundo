package org.example;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        /*
        
        ADAPTACIONES:
        
        En vez de String[] se añaden personas                                               (hecho)
        En vez de ArrayList<String[]> se usa LinkedList<Persona>                            (hecho)
        La busqueda de valores esta sincronizada                                            (hecho)
        Los archivos se reciben por args y se envian en el constructor de ThreadManager     (hecho)
        
        
        */
        
        /*

        Esta aplicación se ejecuta de la siguiente maner:

        Se instancia un ThreadManager, al instanciarse este crea un ArrayList<String[]>
        vacio. Al llamarse el metodo getFiles el ThreadManager recopila los
        archivos en la carpeta files de este proyecto y los devuelve como un ArrayList<File>

        La clase ThreadManager utiliza esta lista en setupThreads para generar tantos hilos como elementos tenga y otorga
        a cada uno una referencia File para que pueda extraer su informacion y una referencia al
        ArrayList<String[]> para poder acceder a esta, ver donde tendrian que insertar su tupla y realizar la
        acción de forma sincrona

        El metodo startProcess situa en estado listo a todos los hilos contenidos en la instancia, estos hilos
        intentan acceder al fichero, leer el contenido y realizar las acciones de añadido dichas antes

        Mientras tanto ThreadManager ejecuta cada x milisegundos una acción de comprobación que se asegura de que todos
        los hilos hayan terminado su tarea. Una vez se detecta la finalización de todos los hilos el metodo startProcess
        devolvera un boolean verdadero, lo cual llevara a la solicitud de una representacion textual del ArrayList<String[]>
        para comprobar el resultado

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