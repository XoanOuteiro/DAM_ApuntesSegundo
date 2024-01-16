package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * Este hilo trata de acceder de forma constante
 * (pero sincronizada a otros hilos) a leer información
 * de su fichero asignado para despúes añadirlo al
 * recurso compartido
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


            }

        }catch(Exception ex){

            System.out.println("!> FATAL: Error imprevisto en la ejecución de un hilo: " + ex.getLocalizedMessage() + " " + ex.getClass().toString());

        }

    }
}
