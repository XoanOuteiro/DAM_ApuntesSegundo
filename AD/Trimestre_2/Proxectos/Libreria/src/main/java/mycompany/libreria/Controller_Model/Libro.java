package mycompany.libreria.Controller_Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="libros",
        uniqueConstraints={@UniqueConstraint(columnNames={"IdLibro"})})
public class Libro {

    /*

        ---Class atributes

     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IdLibro", nullable=false, unique=true, length=11)
    private int idlibro;

    @Column(name="Titulo", nullable=false, length=25)
    private String titulo;

    @Column(name="Precio", nullable=false)
    private float precio;

    @OneToOne
    @JoinColumn(name = "autor", referencedColumnName="dniautor")
    private Autor autor;

    /*

        ---Builder methods

     */
    public Libro(String titulo, float precio, Autor autor){

        this.titulo = titulo;
        this.precio = precio;
        this.autor = autor;

    }

    public Libro(){}

    /*

        ---Getters & Setters

     */
    public int getIdlibro() {
        return idlibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public Autor getAutor() {
        return autor;
    }
}
