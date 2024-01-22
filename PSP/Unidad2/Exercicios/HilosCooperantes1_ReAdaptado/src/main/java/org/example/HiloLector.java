package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * Este hilo trata de acceder de forma constante
 * (pero sincronizada a otros hilos) a leer información
 * de su fichero asignado para despúes añadirlo al
 * recurso compartido
 * 
 * @author XoanOuteiro
 *
 */
public class HiloLector extends Thread{

    /*

        ---ATRIBUTOS DE CLASE

     */
    private File file;
    private LinkedList<Persona> thList; // TODAS LAS MODIFICACIONES A ESTE RECURSO SON CRITICAS
    private BufferedReader br;

    /*

        ---METODOS DE INSTANCIADO

     */
    public HiloLector(File f, LinkedList<Persona> thList) throws FileNotFoundException {

        this.file = f;
        this.thList = thList;
        this.br = new BufferedReader(new FileReader(this.file));

    }

    /*

        ---METODOS HEREDADO

     */
    @Override
    public void run() {

        try {

            String line;
            while ((line = br.readLine()) != null) {

                //Recolección de valores para clase persona
                char inicial = line.charAt(0);

                //Creación de persona
                Persona pers = new Persona(inicial, line);

                //Comprobacion de orden alfabetico
                /*

                   Esta comprobacion no modifica el estado del objeto resource
                   por lo que no es una sección crítica, no obstante podría ser bueno
                   englobarlo como tal para asegurar atomicidad (?) Claro que esto
                   haría la operación mucho mas lenta

                 */
                /*

                //Esta opcion testada usa una expresion lambda para ordenar tras añadir el elemento

                synchronized (this.thList){

                    this.thList.add(tuple);
                    Collections.sort(this.thList, Comparator.comparing(a -> a[1]));

                }

                 */
                
                /*
                    Este metodo, al crear un clon de la lista para evitar
                    la modificacion concurrente no necesariamente devuelve el
                    indice alfabetico real, ya que la lista original pudo ser 
                    modificada por otro hilo
                
                    Pero el enunciado da a entender que la busqueda del indice
                    deberia ser una operacion asincrona, con lo que debe funcionar
                    siempre a partir de un clon de la lista, este problema solo se puede
                    evitar declarando esta linea como sincrona a thList
                */
                
                              
                synchronized (this.thList){
                    
                    int pos = this.findIndex(pers.getInicial());
                    this.thList.add(pos,pers);

                }

            }

        }catch(Exception ex){

            System.out.println("!> FATAL: Error imprevisto en la ejecución de un hilo: " + ex.getLocalizedMessage() + " " + ex.getClass().toString());

        }

    }

    /**
     *
     * Devuelve el indice en el que deberia estar el valor en caso
     * de estar en la lista de forma alfabetica
     *
     * A quien este leyendo esto, atento, estas a punto de ver la forma
     * mas vaga de encontrar indices alfabeticos
     *
     * @return int
     */
    private int findIndex(char c){

        LinkedList<Persona> thListClone = new LinkedList<>(this.thList);
        Persona tempPerson = new Persona(c, ""); 
        thListClone.add(tempPerson);
        Collections.sort(thListClone, Comparator.comparing(Persona::getInicial));
        return thListClone.indexOf(tempPerson);

    }
}
