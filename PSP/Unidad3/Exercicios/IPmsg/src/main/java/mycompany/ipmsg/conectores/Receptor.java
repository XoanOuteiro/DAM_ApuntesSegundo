package mycompany.ipmsg.conectores;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XoanOuteiro
 */
public class Receptor {

    private int puerto;
    private ServerSocket serv;
    private Socket cli;

    public Receptor(int puerto) throws IOException {

        this.puerto = puerto;

        try {

            this.serv = new ServerSocket(puerto);

        } catch (IOException io) {

            throw new IOException("Error al crear el receptor con puerto: " + puerto + ": " + io.getLocalizedMessage());

        }

    }

    public String solicitar() throws IOException{
        
        this.cli = this.serv.accept(); // Esperar un mensaje

        // CREO FLUJO DE ENTRADA DE CLIENTE
        InputStream entrada = null;
        entrada = this.cli.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        
        return flujoEntrada.readLine();

    }

    public void cerrarSocket() throws IOException {

        try {

            this.serv.close();

        } catch (IOException ex) {

            throw new IOException("Error al cerrar el receptor: " + ex.getLocalizedMessage());

        }

    }

}
