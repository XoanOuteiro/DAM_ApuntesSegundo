package modelo;

import java.util.ArrayList;

/**
 *
 * @author XoanOuteiro
 */
public class Alumno {

    //Instance atributes
    private String nombre;
    private String localidad;
    private ArrayList<Modulo> modulos;

    //Build methods
    public Alumno(String nombre, String localidad){
        
        this.nombre = nombre;
        this.localidad = localidad;
        this.modulos = new ArrayList();
        
    }
    
    public Alumno(String nombre, String localidad, ArrayList<Modulo> modulos){
        
        this.nombre = nombre;
        this.localidad = localidad;
        this.modulos = modulos;
        
    }
    
    //Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setModulos(ArrayList<Modulo> modulos) {
        this.modulos = modulos;
    }

    //Utility methods
    public void añadirModulo(Modulo a){
        
        this.modulos.add(a);
        
    }
}
