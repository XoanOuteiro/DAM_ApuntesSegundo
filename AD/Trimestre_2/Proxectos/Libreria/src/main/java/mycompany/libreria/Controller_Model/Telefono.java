package mycompany.libreria.Controller_Model;

import javax.persistence.*;

@Entity
@Table(name = "telefonos",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"ID"})})

public class Telefono {

    @OneToOne
    @JoinColumn(name = "dniautor", referencedColumnName="dniautor")
    private Autor dniautor;

    @Column(name = "telefono", nullable = false, length = 9)
    private String telf;

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private int id;


    public Telefono(Autor atr, String telf){

        this.dniautor = atr;
        this.telf = telf;

    }

    public Telefono(){};

}
