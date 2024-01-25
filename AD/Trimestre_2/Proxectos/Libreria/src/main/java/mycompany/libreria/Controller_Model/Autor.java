
package mycompany.libreria.Controller_Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author XoanOuteiro
 */
@Entity
@Table(name="autores", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"DniAutor"})})
public class Autor implements Serializable {

    /*

        ---Class attributes

     */
    @Id
    @Column(name="DniAutor", nullable=false, unique=true, length=9)
    private String dniautor;

    @Column(name="Nombre", nullable=false, length=25)
    private String nombre;

    @Column(name="Nacionalidad", nullable=false, length=25)
    private String nacionalidad;

    /*

        ---Builder methods

    */

    public Autor(String dniautor, String nombre, String nacionalidad) {
        this.dniautor = dniautor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    public Autor(){
        
    }

    /*

            ---Getters & Setters

        */
    public String getDniautor() {
        return dniautor;
    }

    public void setDniautor(String dniautor) {
        this.dniautor = dniautor;
    }
    
}
