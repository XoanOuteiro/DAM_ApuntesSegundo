package mycompany.ipmsg.conectores;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author XoanOuteiro
 */
public class Emisor {

    private int puerto;
    private String ipDestino;
    private Socket con;

    public Emisor(int puerto, String ipDestino) throws IOException {

        this.puerto = puerto;
        this.ipDestino = ipDestino;

        try {

            this.con = new Socket(this.ipDestino, this.puerto);

        } catch (IOException ex) {

            throw new IOException("Error al conectar a: " + this.ipDestino + "/" + this.puerto + " ERR: " + ex.getLocalizedMessage());

        }

    }

    public void emitir(String s) throws IOException {

        try {
            
            // CREO FLUJO DE SALIDA AL SERVIDOR, una vez conectado el socket
            OutputStream salida = null;
            salida = this.con.getOutputStream();//método de la clase Socket 
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF(s);
            
        } catch (IOException ex) {
            
            throw new IOException("Error al emitir mensaje: " + ex.getLocalizedMessage());

        }

    }

    public void cerrarEmisor() throws IOException {

        try {

            this.con.close();

        } catch (IOException ex) {

            throw new IOException("Error al cerrar el emisor: " + ex.getLocalizedMessage());

        }

    }

}
