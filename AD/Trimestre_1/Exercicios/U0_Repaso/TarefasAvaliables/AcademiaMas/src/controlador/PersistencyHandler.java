package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Modulo;

/**
 *
 * Manages the input and output of this program ensuring that the saved data can
 * exist after termination
 *
 * This is the only class of the controller due to the applications simplicity
 *
 * @author XoanOuteiro
 */
public class PersistencyHandler {

    //Instance Atributes
    private String urlAlumnos = "files/alumnos.txt";
    private String urlModulos = "files/modulos.txt";

    private File refAlumnos;
    private File refModulos;

    private ObjectOutputStream oosAlumnos;
    private ObjectOutputStream oosModulos;

    private ObjectInputStream oisAlumnos;
    private ObjectInputStream oisModulos;

    //Initialization methods
    /**
     *
     * Initializes needed systems for saving and loading data to files
     *
     * @throws IOException If files cant be accessed
     */
    public PersistencyHandler() throws IOException {

        //Create logical representations of both files
        this.refAlumnos = new File(this.urlAlumnos);
        this.refModulos = new File(this.urlModulos);

        //Run initialization protocol
        this.init(this.refAlumnos);
        this.init(this.refModulos);

    }

    private void init(File f) throws IOException {
        if (!f.exists()) {
            f.createNewFile();
        }
    }

    //Interfacing methods
    public void writeAlumnos(ArrayList alumnos) throws IOException {
        
        this.oosAlumnos = new ObjectOutputStream(new FileOutputStream(this.refAlumnos));

        this.oosAlumnos.writeObject(alumnos);
        
        oosAlumnos.close();

    }

    public void writeModulos(ArrayList modulos) throws IOException {
        
        this.oosModulos = new ObjectOutputStream(new FileOutputStream(this.refModulos));

        this.oosModulos.writeObject(modulos);
        
        oosModulos.close();

    }

    public ArrayList<Alumno> retrieveAlumnos() throws IOException, ClassNotFoundException {
        
        this.oisAlumnos = new ObjectInputStream(new FileInputStream(this.refAlumnos));

        ArrayList<Alumno> returnable;

        returnable = (ArrayList<Alumno>) this.oisAlumnos.readObject();

        oisAlumnos.close();
        
        return returnable;

    }

    public ArrayList<Modulo> retrieveModulos() throws IOException, ClassNotFoundException {
        
        this.oisModulos = new ObjectInputStream(new FileInputStream(this.refModulos));

        ArrayList<Modulo> returnable;

        returnable = (ArrayList<Modulo>) this.oisModulos.readObject();

        oisModulos.close();
        
        return returnable;

    }

}
