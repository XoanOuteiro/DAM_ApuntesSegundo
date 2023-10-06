/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarefa2;

import java.io.Serializable;

/**
 *
 * @author a22braisdr
 */
public class Modulo  implements Serializable{
    private int unidades;
    private String nombre;
    private int horas;

    public Modulo(int unidades, String nombre, int horas) {
        this.unidades = unidades;
        this.nombre = nombre;
        this.horas = horas;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    
    
    
}
