package ex_aleatorios2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author XoanOuteiro
 */
public class Ex_Aleatorios2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String line;
        if (args.length <= 0) {
            System.err.println("Se necesita un programa a ejecutar");
            System.exit(-1);
        }
        //args es  aleatorioshijo.exe
        try {
            String refHijo = args[0];
            String refHijo2 = args[1];

            Process hijo = new ProcessBuilder(refHijo).start();
            Process hijo2 = null;

            int n = 0;

            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

            //br es un stream de entrada conectado  (mediante una pipe) a la salida estándar del proceso hijo
            // el proceso aleatorios (padre) leerá en él la información que el proceso hijo le deja.
            // en este caso un nuevo número aleatorio
            PrintStream ps = new PrintStream(hijo.getOutputStream());
            // ps es un stream de salida conectado (mediante una pipe) a la entrada estandar del hijo.
            //  el proceso padre envía cadenas al hijo ( aquí con cada cadena solicitando un número aleatorio más)
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            while ((in.readLine()).compareTo("fin") != 0) {

                ps.println("dame un numero "); //No es necesario escribir nada en concreto, da igual  que cadena 
                // de hecho la cadena tecleada por usuario no la recojemos.
                ps.flush(); // Asegura que los datos se han enviado

                if ((line = br.readLine()) != null) {
                    System.out.println(line);
                    n = Integer.parseInt(line); //Guardamos el último número antes de fin para ver cuantas veces esperar al proceso 2

                    //Iniciamos hijo2 con el valor n recibido en condicion the break del programa uno
                    hijo2 = new ProcessBuilder(refHijo2).start();

                    for (int i = 0; i < n; i++) {

                        String res = in.readLine();
                        ps.println(res);

                    }

                }

            }//fin while
            hijo.destroy();
            //el proceso padre finaliza  la ejecución del proceso hijo, al leer "fin"

            //usuario teclea "fin", padre finaliza el proceso hijo
            System.out.println("Finalizando");

        } catch (IOException e) {
            System.out.println("Error ocurrió durante la ejecución.Descripción del error:" + e.getMessage());
        }

    }

}
