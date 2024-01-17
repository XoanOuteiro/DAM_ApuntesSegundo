package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        ---CONSTANTES DE INDEXADO

     */
    private final int POS_LONGITUD = 0;
    private final int POS_INICIAL = 1;
    private final int POS_CADENA = 2;

    /*

        ---ATRIBUTOS DE CLASE

     */
    private File file;
    private ArrayList<String[]> thList; // TODAS LAS MODIFICACIONES A ESTE RECURSO SON CRITICAS
    private BufferedReader br;

    /*

        ---METODOS DE INSTANCIADO

     */
    public HiloLector(File f, ArrayList<String[]> thList) throws FileNotFoundException {

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

                //Recolección de valores para tupla
                int longitud = line.length();
                char inicial = line.charAt(0);

                //Creación de tupla
                String[] tuple = {Integer.toString(longitud),Character.toString(inicial),line};

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
                int pos = this.findIndex(tuple[this.POS_INICIAL]);
                              
                synchronized (this.thList){

                    this.thList.add(pos,tuple);

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
    private int findIndex(String s){

        ArrayList<String[]> thListClone = new ArrayList<>(this.thList);     // Lo clonamos para no ordenarlo sin querer (si)
        String[] tempArr = {"",s,""};                                         //Creamos un array que solo tiene la inicial
        thListClone.add(tempArr);                                           //Metemos el array en la lista
        Collections.sort(thListClone, Comparator.comparing(a -> a[this.POS_INICIAL]));  //Lo sorteamos

        return thListClone.indexOf(tempArr); //Recuperamos el indice en el que se añadiria
        //NO COPIAR ESTO EN UN EXAMEN POR FAVOR

    }
}
