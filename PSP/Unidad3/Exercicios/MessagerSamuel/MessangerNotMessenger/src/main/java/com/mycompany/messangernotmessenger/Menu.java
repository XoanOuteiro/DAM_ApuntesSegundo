/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.messangernotmessenger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a22samuelfn
 */
public class Menu {

    private Scanner scan = new Scanner(System.in);
    private Socket conexion;
    private DataOutputStream salida;
    private DataInputStream entrada;

    public void start() {
        System.out.println("Emisor primero? 0 SI 1 NO");
        int decision = scan.nextInt();
        scan.nextLine();

        if (decision == 0) {

            conexion = recibirServer();
            getSalida();

        } else {

            conexion = recibirCliente();
            getEntrada();
            recibirMensaje();

        }

        String mensaje = escribirMensaje();

        while (!mensaje.equals("salir")) {

            try {

                getSalida();
                salida.writeUTF(mensaje);

            } catch (IOException ex) {

                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);

            }

            getEntrada();
            recibirMensaje();
            mensaje = escribirMensaje();

        }
    }

    private String escribirMensaje() {

        String mensaje;
        System.out.println("Mensaje a enviar:");
        mensaje = scan.nextLine();
        return mensaje;

    }

    private void recibirMensaje() {

        try {

            System.out.println("Esperando mensaje: \n");
            System.out.println(entrada.readUTF());

        } catch (IOException ex) {

            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void crearSalidaEntrada() {

        getSalida();
        getEntrada();

    }

    private void getEntrada() {
        try {
            entrada = new DataInputStream(conexion.getInputStream());  //this << other
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getSalida() {
        try {
            salida = new DataOutputStream(conexion.getOutputStream());  //this >> other
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Socket recibirServer() {

        System.out.println("IP:");
        String ip = scan.nextLine();
        System.out.println("Puerto:");
        int puerto = scan.nextInt();
        scan.nextLine();

        try {

            Socket cliente = new Socket(ip, puerto);
            return cliente;

        } catch (IOException ex) {

            System.out.println("No encuentra server.\n" + ex.getLocalizedMessage());

        }
        return null;
    }

    private Socket recibirCliente() {

        System.out.println("Puerto:");
        int puerto = scan.nextInt();
        scan.nextLine();

        try {

            ServerSocket servidor = new ServerSocket(puerto);
            Socket cliente = servidor.accept();
            return cliente;

        } catch (IOException ex) {

            System.out.println("recibirCliente.\n" + ex.getLocalizedMessage());

        }
        return null;
    }
}
