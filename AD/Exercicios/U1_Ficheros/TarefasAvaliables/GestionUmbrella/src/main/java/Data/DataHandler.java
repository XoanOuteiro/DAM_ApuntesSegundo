package Data;

import Model.Empleado;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * Allows for the input and output of savestates
 *
 * @author XoanOuteiro
 */
public class DataHandler {

    //Atributes
    private final String URL = "files/System.txt";

    private File refSystem;

    private ObjectOutputStream oos;



    //Builders
    public DataHandler() throws IOException{

        this.refSystem = new File(this.URL);

        this.init(this.refSystem);

    }

    //Methods

    /**
     *
     * Attempts to do an import from the system file, if it fails
     * it imprints an empty ArrayList onto the file and loads into
     * the process, this way ensuring that even when force-quitting
     * the file won't be empty on the next execution.
     *
     * If it doesn't failt it returns the ArrayList contained on System.
     *
     * @return ArrayList of Empleado
     */
    public ArrayList<Empleado> doImport() {

        return new ArrayList<>(); //To be done

    }

    private void init(File f) throws IOException {
        if (!f.exists()) {
            f.createNewFile();
        }
    }
}
