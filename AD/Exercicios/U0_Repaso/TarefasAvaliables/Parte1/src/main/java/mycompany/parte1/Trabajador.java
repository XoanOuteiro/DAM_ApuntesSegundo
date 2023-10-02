package mycompany.parte1;

/**
 *
 * @author XoanOuteiro
 */
public class Trabajador {

    //Class instance atributes
    private String nombre;
    private int edad;
    private int categoria;
    private int antiguedad;

    //Class constants
    public static final int CAT_EMPLEADO = 0;
    public static final int CAT_ENCARGADO = 1;
    public static final int CAT_DIRECTIVO = 2;

    public static final int ANT_NOVATO = 0;
    public static final int ANT_MADURO = 1;
    public static final int ANT_EXPERTO = 2;

    //Constructors
    /**
     *
     * Creates an instance of this class if and only if categoria and antiguedad
     * are within the [0,2] range of whole values.
     * 
     * @param nombre string value to represent name
     * @param edad integer value to represent age
     * @param categoria has to be [0,2]
     * @param antiguedad has to be [0,2]
     * @throws IllegalArgumentException
     */
    public Trabajador(String nombre, int edad, int categoria, int antiguedad) throws IllegalArgumentException {

        if ((this.checkRange(categoria)) && (this.checkRange(antiguedad))) {

            this.nombre = nombre;
            this.edad = edad;
            this.categoria = categoria;
            this.antiguedad = antiguedad;

        } else {

            argumentOOBthrow();

        }

    }

    //Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCategoria(int categoria) {

        if (checkRange(categoria)) {

            this.categoria = categoria;

        } else {

            this.argumentOOBthrow();

        }

    }

    public void setAntiguedad(int antiguedad) {

        if (checkRange(antiguedad)) {

            this.antiguedad = antiguedad;

        } else {

            this.argumentOOBthrow();

        }
    }

    //Public methods
    /**
     * 
     * Calculates a double price value based on this classes static contants
     * 
     * @return double The ammount of money to be payed to the caller instance
     * 
     */
    public double calcularSueldo() {
        double sueldoBase = 607;
        double sueldoFinal = 0;

        
        //Category switch increment
        switch (this.categoria) {

            case CAT_EMPLEADO:

                sueldoFinal = sueldoBase + (sueldoBase * (15 / 100));
                break;

            case CAT_ENCARGADO:

                sueldoFinal = sueldoBase + (sueldoBase * (35 / 100));
                break;

            case CAT_DIRECTIVO:

                sueldoFinal = sueldoBase + (sueldoBase * (15 / 100));
                break;
        }
        
        //Antiguedad switch increment
        switch (this.categoria) {

            case ANT_NOVATO:

                sueldoFinal = sueldoBase + 150;
                break;

            case ANT_MADURO:

                sueldoFinal = sueldoBase + 300;
                break;

            case ANT_EXPERTO:

                sueldoFinal = sueldoBase + 600;
                break;
        }
        
        return sueldoFinal;
    }
    
    
    //Private methods
    private boolean checkRange(int val) {

        if (val >= 0 && val <= 2) {

            return true;

        } else {

            return false;

        }

    }

    private void argumentOOBthrow() throws IllegalArgumentException {

        throw new IllegalArgumentException("Args categoria o argumento not within correct range");

    }

}
