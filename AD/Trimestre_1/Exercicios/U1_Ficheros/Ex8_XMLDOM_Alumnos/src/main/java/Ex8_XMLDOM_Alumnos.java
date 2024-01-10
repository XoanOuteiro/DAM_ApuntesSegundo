
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author XoanOuteiro
 */
public class Ex8_XMLDOM_Alumnos {

    public static void main(String[] args) {

        String leer = "Hola";

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document estudiantes = builder.parse(new File("estudiantes.xml"));
            DomModf tmp = new DomModf(estudiantes);

            Scanner scan = new Scanner(System.in);

            while (!leer.equals("n")) {

                System.out.println("Nuevo estudiante?(s|n)");
                leer = scan.nextLine();

                if (leer.equals("s")) {

                    añadir(tmp);

                }
            }

            tmp.escribir();

        } catch (ParserConfigurationException | SAXException | IOException ex) {

            System.out.print("Nada fallo");
            System.exit(0);

        }
    }

    private static void añadir(DomModf tmp) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Nombre estudiante:");
        String nombre = scan.nextLine();

        System.out.println("Edad estudiante:");
        String edad = scan.nextLine();

        tmp.añadirEstudiante(nombre, edad);

    }

}
