
import java.io.Serializable;
import java.util.Date;


/**
 * Data class representing a hospital user
 *
 * @author XoanOuteiro
 */
public class Paciente implements Serializable{
    
    //Instance atributes
    
    private String nif;
    private String nombre;
    private String apellidos;
    private String direccion;
    private Date fechaUltimaVisita;
    private boolean alergia;
    private char tipo;
    
    //Builder methods
    public Paciente(String nif, String nombre, 
                        String apellidos, String direccion, 
                        boolean alergia,char tipo){
        
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.alergia = alergia;
        this.tipo = tipo;
        this.fechaUltimaVisita = null;
        
    }
    
    
    //Getters and setters

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public Date getFechaUltimaVisita() {
        return fechaUltimaVisita;
    }

    public boolean isAlergia() {
        return alergia;
    }

    public char getTipo() {
        return tipo;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaUltimaVisita(Date fechaUltimaVisita) {
        this.fechaUltimaVisita = fechaUltimaVisita;
    }

    public void setAlergia(boolean alergia) {
        this.alergia = alergia;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
}
