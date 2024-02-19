package mycompany.ipmsg;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mycompany.ipmsg.conectores.Emisor;
import mycompany.ipmsg.conectores.Receptor;

/**
 *
 * @author XoanOuteiro
 */
public class Gestor {

    private boolean firstState = false; //False = 0 (receptor primero), True = 1 (emisor primero)
    private final String EXIT = ":q";

    private Receptor receptor;
    private Emisor emisor;

    public Gestor() {
    }

    public void init() {

        Scanner reads = new Scanner(System.in);

        System.out.println(">>Escoge si uno de estos estados: ");
        System.out.println(">> [0] Para iniciar como receptor primero");
        System.out.println(">> [1] Para iniciar como emisor primero");

        String value = reads.nextLine();

        this.firstState = value.equals("1");
        System.out.println(this.firstState);
        this.menu();

    }

    public void menu() {

        Scanner reads = new Scanner(System.in);

        String ip = this.pedirIP();
        int puertoA = this.pedirPuerto(); //Para emisor
        int puertoB = this.pedirPuerto(); //Para receptor

        boolean hasExited = false;

        if (firstState) {
            
            try{
                
                this.emisor = new Emisor(puertoA, ip);
                this.receptor = new Receptor(puertoB);
                
            }catch(IOException ex){
                
                System.out.println(ex.getLocalizedMessage());
                
            }

            do {
                
                System.out.println("[+] Escribe un mensaje: ");
                String line = reads.nextLine();
                if (!line.equals(EXIT)) {

                    try {
                        this.emisor.emitir(line);
                    } catch (IOException ex) {
                        System.out.println(ex.getLocalizedMessage());
                    }

                } else {

                    hasExited = true;

                }

                if (!hasExited) {
                    try {

                        System.out.println("[-] Esperando un mensaje: ");
                        String val = this.receptor.solicitar();
                        System.out.println(ip + ">>" + val);

                    } catch (IOException ex) {

                        System.out.println(ex.getLocalizedMessage());

                    }
                }

            } while (!hasExited);

        } else {    // FIRST RECEPTOR
            
            try{
                
                this.receptor = new Receptor(puertoB);
                this.emisor = new Emisor(puertoA, ip);
                
            }catch(IOException ex){
                
                System.out.println(ex.getLocalizedMessage());
                
            }

            do {

                try {

                    System.out.println("[-] Esperando un mensaje: ");
                    String val = this.receptor.solicitar();
                    System.out.println(ip + ">>" + val);

                } catch (IOException ex) {

                    System.out.println(ex.getLocalizedMessage());

                }

                System.out.println("[+] Escribe un mensaje: ");
                String line = reads.nextLine();
                if (!line.equals(EXIT)) {

                    try {
                        this.emisor.emitir(line);
                    } catch (IOException ex) {
                        System.out.println(ex.getLocalizedMessage());
                    }

                } else {

                    hasExited = true;

                }

            } while (!hasExited);

        }

        try {

            this.emisor.cerrarEmisor();
            this.receptor.cerrarSocket();

        } catch (IOException ex) {

            System.out.println(ex.getLocalizedMessage());

        }

    }

    private void initReceptor(int puerto) {

        try {

            this.receptor = new Receptor(puerto);

        } catch (IOException ex) {

            System.out.println(ex.getLocalizedMessage());

        }

    }

    private void initEmisor(int puerto, String ip) {

        try {

            this.emisor = new Emisor(puerto, ip);

        } catch (IOException ex) {

            System.out.println(ex.getLocalizedMessage());

        }

    }

    private String pedirIP() {

        Scanner reads = new Scanner(System.in);
        System.out.println(">>Escribe la IP a la que conectar: ");
        return reads.nextLine();

    }

    private int pedirPuerto() {

        boolean done = false;
        int puertoInt = 0000;

        do {
            Scanner reads = new Scanner(System.in);
            System.out.println(">>Escribe el puerto de operación: ");
            String puerto = reads.nextLine();
            try {

                puertoInt = Integer.parseInt(puerto);
                done = true;

            } catch (Exception ex) {

                System.out.println("!>ERROR: Eso no es un puerto válido, vuelve a intentarlo.");

            }
        } while (!done);

        return puertoInt;

    }

}
