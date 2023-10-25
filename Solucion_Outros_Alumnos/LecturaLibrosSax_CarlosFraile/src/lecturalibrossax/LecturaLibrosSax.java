/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lecturalibrossax;

/**
 *
 * @author a14carlosfd
 */
public class LecturaLibrosSax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Factory factoria = new Factory();
       factoria.cargarDatos("librosinfo.xml");
    }
    
}
