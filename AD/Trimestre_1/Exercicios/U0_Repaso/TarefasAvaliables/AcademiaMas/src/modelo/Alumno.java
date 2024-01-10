package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * Represents a students
 *
 * @author XoanOuteiro
 */
public class Alumno implements Serializable{

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
    /**
     * 
     * Adds the given module to a list accesible via getter
     * 
     * @param a 
     */
    public void añadirModulo(Modulo a){
        
        this.modulos.add(a);
        
    }
    
    /**
     * 
     * Returns a list of the names of all the Modulos contained by this
     * instance if there is at least one
     * 
     * @return String[]
     * @throws IndexOutOfBoundsException if length is less than 1
     */
    public String[] getNombreModulos() throws IndexOutOfBoundsException{
        
        if(!modulos.isEmpty()){
        
            String[] returnable = new String[modulos.size()];
        
            for (int i = 0; i < modulos.size(); i++) {
            
                returnable[i] = modulos.get(i).getNombre();
            
            }
        
            return returnable;
            
        }else{
            
            throw new IndexOutOfBoundsException("Erro: Este alumno non conten modulos");
            
        }
        
    }
    
    /**
     * 
     * Returns the sum of all the hours of every Modulo that this
     * instance has in its list
     * 
     * @return double
     */
    public double getNumeroHoras(){
        
        double returnable = 0;
        
        for(Modulo m : this.modulos){
            
            returnable = returnable + m.getHoras();
            
        }
        
        return returnable;
        
    }
}
