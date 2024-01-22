package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * Instancia encargada de la creación y lanzamiento
 * de hilos para resolver una tarea:
 *
 * En este ejercicio la tarea es insertar tuplas de 3 datos en orden alfabetico
 * en una lista dinamica a partir n ficheros habiendo por lo tanto n hilos
 *
 * En este ejercicio esta clase sera una instancia única con lo cual tomará
 * el papel de actividad principal del hilo primario, siendo asi el nodo mas alto
 * del arbol de hilos final
 *
 *
 * @author XoanOuteiro
 */
public class ThreadManager {

    /*

        ---ATRIBUTOS DE CLASE

     */
    /**
     *
     * Recurso compartido de todos los hijos de este proceso.
     *
     *
     * Contenidos por tupla:
     * [i0 = Longitud de cadena leida del fichero,
     *  i1 = Inicial de la cadena (valor por el cual ordenamos por orden alfabetico)
     *  i2 = La cadena en si]
     *
     */
    private LinkedList<Persona> resource;

    /**
     *
     * Contiene dinamicamente una cantidad n
     * (donde n= numero de ficheros en la carpeta files)
     * de hilos de la clase HiloLector
     *
     */
    private ArrayList<HiloLector> threads;

    private final File filesFolder = new File("files");

    /*

        ---METODOS DE INSTANCIADO

     */
    public ThreadManager(){

        this.resource = new LinkedList();

    }


    /*

        ---METODOS PUBLICOS

     */

    /**
     *
     * Instancia y lanza los hilos de este proceso
     * (esta es la zona de recogida final cualquier excepción)
     *
     * @return True si el proceso fue instanciado y todos los hilos terminaron con exito, False si ocurrió algún fallo
     */
    public boolean startProcess(){

        try{

            this.cascadeThreads();

            for(Thread t : this.threads){
                
                t.join();
                
            }

            return true;

        }catch(Exception ex){

            return false;

        }

    }

    /**
     *
     * Prepara un hilo para cada fichero en los argumentos
     *
     * @param files
     */
    public void setupThreads(ArrayList<File> files) throws FileNotFoundException {

        this.threads = new ArrayList<>();

        for(File f : files){

            this.threads.add(new HiloLector(f, this.resource));

        }

    }

    /**
     *
     * Lee los archivos en el directorio files
     * en la raiz del proyecto y retorna sus nombres
     *
     * Se puede usar len sobre el array devuelto para
     * ver la cantidad de archivos en el directorio
     *
     * @return String[]
     */
    public ArrayList<File> getFiles(){

        ArrayList<File> returnable = new ArrayList<>();
        Collections.addAll(returnable, filesFolder.listFiles());
        return returnable;

    }

    /**
     *
     * Devuelve una representacion en cadena de caracteres
     * del contenido del ArrayList atributo
     *
     * @return String
     */
    public String getString(){

        String returnable = "";

        for(Persona e : this.resource){

            returnable = returnable + e.toString() + "\n";

        }

        return returnable;

    }


    /*

        ---FUNCIONES PRIVADAS

     */

    /**
     *
     * Situa en estado listo a todos los hilos de la lista threads
     *
     */
    private void cascadeThreads(){

        for(HiloLector l : this.threads){

            l.start();

        }
    }
}
