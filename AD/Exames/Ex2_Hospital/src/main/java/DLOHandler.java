
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Short for Dynamic Listed Object Handler, this ambiguous class (meaning it
 * requires a Wrapper to function) is meant to control the full data flow of a
 * list of objects from and to one single file of extension .txt or .dat the
 * program will likely not break under other file extensions but no issues
 * regarding its use in such situations will be adressed
 *
 * When declared, overwritten and instanced it requires a wrapper to define the
 * object type it will handle, it is therefore logically mandatory that the
 * objects in the list are serializable by class definition (byte serialization
 * is not recommended)
 *
 * UseFlow: 1) Build 2)startFlowSequence 3-n)doPush
 *
 * @author XoanOuteiro
 */
public class DLOHandler<Type> {

    /*
    
        --CLASS ATRIBUTES--
    
     */
    private String filePath;
    private File reference;

    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    /*
    
        ----BUILDER METHODS----
    
     */
    /**
     *
     * Creates a handler for the flow of object type data to and from an
     * specified file
     *
     * Requires a wrapper pointing to a serializable class
     *
     * After creating an instance calling the startFlowSequence method is
     * mandatory to start the data flow
     *
     * @param filePath String
     * @throws IOException when the directory of filePath is not editable
     */
    public DLOHandler(String filePath) throws IOException {

        this.filePath = filePath;
        this.reference = new File(this.filePath);

        this.initFile(this.reference);

    }

    /*
    
        ----INSTANCE METHODS----
    
     */
    /**
     *
     * This method should be called on startup
     *
     * Creates the necesary requirements to transfer typed lists
     *
     * On execution, a request to pull a list from the file is emited, if the
     * request is fulfilled the list containing data is returned, if the request
     * fails another request is sent to write a new empty list onto the file
     * then returning said empty list
     *
     * @return ArrayList with previous saved data, ArrayList empty, null if
     * directory is not editable
     */
    public ArrayList<Type> startFlowSequence() {

        try { //Check if file is empty trying to obtain data

            ArrayList<Type> returnable = this.doPull();

            return returnable; //If the import is succesful the method breaks here

        } catch (IOException | ClassNotFoundException ex) {    //If the exception is caught we assume that our file is empty

            /*
                To ensure the file isnt found empty on a secondary execution
                we imprint it with a header representing an empty list of our
                given object type
             */
            try {

                ArrayList<Type> header = new ArrayList<Type>();

                this.doPush(header);

                return header;

            } catch (IOException err) {

                //If the reference hasn't failed, this is objectively unreachable
                System.out.println("Fatal error: Reference not found and impossible to create, please run program as admin. \n NONE OF YOUR CHANGES WILL BE SAVED");

            }

        }

        return null; //Final nullable, objectively unreachable if directory is editable

    }

    /**
     *
     * Attempts to retrieve a typed list from the original argumented filePath
     *
     * @return ArrayList returned from file
     * @throws IOException if the stream is cut mid-execution
     * @throws ClassNotFoundException if the typing reference could not be
     * resolved
     */
    public ArrayList<Type> doPull() throws IOException, ClassNotFoundException {

        this.ois = new ObjectInputStream(new FileInputStream(this.reference));

        ArrayList<Type> returnable = (ArrayList<Type>) this.ois.readObject();

        this.ois.close();

        return returnable;

    }

    /**
     *
     * Attempts to push the given typed list onto the original argumented
     * filePath hence overwriting the file contents
     *
     * @param pushable ArrayList of same typing as original wrapper
     * @throws IOException when stream is cut mid-execution
     */
    public void doPush(ArrayList<Type> pushable) throws IOException {

        this.oos = new ObjectOutputStream(new FileOutputStream(this.reference));

        this.oos.writeObject(pushable);

        this.oos.close();

    }

    /*
        
        ----PRIVATE UTILITY METHODS----
    
     */
    /**
     *
     * Checks if the given reference points to an existing file, if a file isnt
     * found attempts to create one
     *
     * @param f File
     * @throws IOException when the directory is not editable
     */
    private void initFile(File f) throws IOException {

        if (!f.exists()) {

            try {

                f.createNewFile();

            } catch (IOException ex) {

                throw new IOException("You do not meet the requirements to create a file in this directory"
                        + ". Please, either create it manually or run this program with admin rights");

            }
        }
    }
}
