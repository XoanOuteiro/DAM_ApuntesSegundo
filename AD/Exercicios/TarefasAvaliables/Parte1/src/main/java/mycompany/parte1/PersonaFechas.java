package mycompany.parte1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XoanOuteiro
 */
public class PersonaFechas {

    //Instance atributes
    private String nombre;
    private Date fechaNac;
    private int dia;
    private int mes;
    private int ano;

    /**
     * 
     * Returns an instance of the Person class containing a birthdate and a name
     * 
     * @param nombre
     * @param fechaNac 
     */
    public PersonaFechas(String nombre, String fechaNac) {

        try {
            
            this.nombre = nombre;
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(fechaNac);
            this.fechaNac = date;
            
            //Create splitted values
            String[] splited = fechaNac.split("/");
            this.dia = Integer.parseInt(splited[0]);
            this.mes = Integer.parseInt(splited[1]);
            this.ano = Integer.parseInt(splited[2]);
            
            
            
        } catch (ParseException ex) {
            
            System.out.println(">>ERROR [input unparseable] under this parameters the app will break");
            
        }
        
    }
    
    //Getters and setters

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
}
