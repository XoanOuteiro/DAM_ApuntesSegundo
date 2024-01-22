
package org.example;

/**
 *
 * @author XoanOuteiro
 */
public class Persona {
    
    /*

        ---Atributos de clase
    
    */
    private int longitud;
    private char inicial;
    private String cadena;
    
    /*
    
        ---Constructores
    
    */
    public Persona(char inicial, String cadena){
        
        this.longitud = cadena.length();
        this.inicial = inicial;
        this.cadena = cadena;
            
    }
    
    /*
    
        ---Metodos
    
    */
    @Override
    public String toString(){
        
        String returnable = "Longitud: " + this.longitud + " Inicial: " + this.inicial + " Cadena: " + this.cadena;
        return returnable;
        
    }
    
    /*
    
        ---Getters y Setters
    
    */
    public int getLongitud() {
        return longitud;
    }

    public char getInicial() {
        return inicial;
    }

    public String getCadena() {
        return cadena;
    }
    
    
}
