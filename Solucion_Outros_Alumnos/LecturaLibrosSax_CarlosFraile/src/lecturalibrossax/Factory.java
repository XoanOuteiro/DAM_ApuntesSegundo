/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecturalibrossax;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 *
 * @author a14carlosfd
 */
public class Factory {

    SAXParserFactory factory;

    SAXParser parser;

    public Factory() {
        try {
            factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarDatos(String pathname) {
        try {
            File archivo = new File(pathname);

            LibrosHandler handler = new LibrosHandler();
            parser.parse(pathname, handler);

        } catch (SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
