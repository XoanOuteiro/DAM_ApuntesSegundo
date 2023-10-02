package mycompany.parte1;

/**
 *
 * @author XoanOuteiro
 */
public class Hora {

    //Class Atributes
    int hora;
    int minutos;

    //Class builders
    /**
     *
     * Creates an instance of the hour class if and only if the given values are
     * on the [0,23] and [0,59] ranges.
     *
     * @param hora
     * @param minutos
     * @throws IllegalArgumentException
     */
    public Hora(int hora, int minutos) throws IllegalArgumentException {

        if (checkHourRange(hora) && checkMinuteRange(minutos)) {

            this.hora = hora;
            this.minutos = minutos;

        } else {

            throw new IllegalArgumentException("Values out of range");

        }
    }

    //Utility
    private boolean checkMinuteRange(int min) {

        if (min <= 59 && min >= 0) {

            return true;

        } else {

            return false;

        }
    }

    private boolean checkHourRange(int hr) {

        if (hr <= 23 && hr >= 0) {

            return true;

        } else {

            return false;

        }
    }

    //Required methods
    /**
     * 
     * Generates a 1 minute increment.
     * 
     */
    public void inc() {

        if (this.minutos + 1 < 60) {

            this.minutos = this.minutos + 1;

        } else {

            this.minutos = 0;
            this.hora = this.hora + 1;

        }
    }

    /**
     * 
     * Sets the minutes as the assigned value if applicable
     * 
     * @param val
     * @return true If the value is applicable, false otherwise
     */
    public boolean setMinutos(int val) {

        if (this.checkMinuteRange(val)) {

            this.minutos = val;
            return true;

        } else {

            return false;

        }
    }

    /**
     * 
     * Sets the hours as the assigned value if applicable
     * 
     * @param val
     * @return true If the value is applicable, false otherwise
     */
    public boolean setHoras(int val) {

        if (this.checkHourRange(val)) {

            this.minutos = val;
            return true;

        } else {

            return false;

        }
    }
    
    /**
     * 
     * Gives a String representation of the instance in the
     * [hh hr : mm min] format
     * 
     * @return String
     */
    public String toString(){
        
        String returnable = this.hora + "hr : " + this.minutos + "min";
        
        return returnable;
        
    }

}
