
package modelo;

import java.io.Serializable;

/**
 *
 * Represents a subject
 * 
 * @author XoanOuteiro
 */
public class Modulo implements Serializable{
    
    //Instance atributes
    private String nombre;
    private int horas;
    private int unidades;
    
    //Builder methods
    public Modulo(String nombre, int horas, int unidades){
        
        this.nombre = nombre;
        this.horas = horas;
        this.unidades = unidades;
        
    }
    
    //Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public int getHoras() {
        return horas;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    @Override
    public String toString(){
        
        return this.getNombre();
        
    }
    
}
