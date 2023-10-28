package Model;

/**
 *
 * Represents an employee logically
 *
 * @author XoanOuteiro
 */
public class Empleado {

    //Instance data
    private String nif;
    private String nombre;
    private String apellidos;
    private float salario;

    //Builder methods
    public Empleado(String nif, String nombre, String apellidos, float salario) {

        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;

    }

    //Instance methods
    //Getters and Setters
    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public float getSalario() {
        return salario;
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

    public void setSalario(float salario) {
        this.salario = salario;
    }

}
