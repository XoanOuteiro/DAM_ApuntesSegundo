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

    private final File refSystem;

    private ObjectOutputStream oos;
    private ObjectInputStream ois;



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
     * If it doesn't fail it returns the ArrayList contained on System.
     *
     * @return ArrayList of Empleado
     */
    public ArrayList<Empleado> doImportSequence() {

        try{ //Check if file is empty trying to obtain data

            ArrayList<Empleado> returnable = this.retrieveSystem();

            return returnable; //If the import is succesful the method breaks here

        }catch(IOException | ClassNotFoundException ex){    //If the exception is caught we assume that our file is empty

            /*
                We ensure that this part is only a first-time executable imprinting a
                default empty header for our ArrayList of employees. Be there no inputs
                our system will never reach this part again unless the file is deleted
             */

            try {

                ArrayList<Empleado> header = new ArrayList<Empleado>();

                this.outputSavestate(header);

                return header;

            } catch (IOException err) {

                //If the reference hasn't failed, this is objectively unreachable
                System.out.println("Fatal error: Reference not found and impossible to create, please run program as admin. \n NONE OF YOUR CHANGES WILL BE SAVED");

            }

        }

        return null;    //Final absolute nullable.

    }

    public ArrayList<Empleado> retrieveSystem() throws IOException, ClassNotFoundException {

        this.ois = new ObjectInputStream(new FileInputStream(this.refSystem));

        ArrayList<Empleado> returnable = (ArrayList<Empleado>) this.ois.readObject();

        this.ois.close();

        return returnable;
    }

    public void outputSavestate(ArrayList<Empleado> e) throws IOException {

        this.oos = new ObjectOutputStream(new FileOutputStream(this.refSystem));

        this.oos.writeObject(e);

        this.oos.close();

    }

    private void init(File f) throws IOException {
        if (!f.exists()) {
            f.createNewFile();
        }
    }
}
