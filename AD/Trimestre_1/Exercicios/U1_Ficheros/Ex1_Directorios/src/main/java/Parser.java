
import java.io.File;
import java.io.IOException;

/**
 *
 * @author XoanOuteiro
 */
public class Parser {

    public Parser() {

    }

    public void switchType(String path) throws IOException {

        File dir = new File(path);

        if (dir.exists()) {

            this.listFilesInFolder(dir);

        } else {

            throw new IOException("FATAL: Directory not found");

        }
    }

    private void listFilesInFolder(File f) {

        File[] listOfFiles = f.listFiles();

        if (f.isDirectory()) {

            for (File file : listOfFiles) {
                if (file.isFile()) {

                    System.out.println(file.getName() + " Es un fichero");

                }
                if (file.isDirectory()) {

                    System.out.println(file.getName() + " Es un directorio");

                }
            }

        } else {

            System.out.println(f.getName() + " Es un fichero");

        }

    }
}
