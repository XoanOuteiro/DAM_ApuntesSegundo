/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarefa2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author a22braisdr
 */
public class Alumno  implements Serializable{
    private String nombre;
    private String localidad;
    private ArrayList <Modulo> modulos;

    public Alumno(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
        modulos=new ArrayList<>();
    }
    
    public Alumno(String nombre, String localidad, ArrayList<Modulo> modulos) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.modulos=modulos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    
    public void engadirModulo(Modulo a){
        modulos.add(a);
    }
    
    public String[] getNombreModulos(){
        String[] nombres=new String[modulos.size()];
        for (int cont=0; cont<modulos.size(); cont++) {
            nombres[cont]=modulos.get(cont).getNombre();
        }
        return nombres;
    }
    
    public double getNumeroHoras(){
        double horasTotales=0;
        for (int cont=0; cont<modulos.size(); cont++) {
            horasTotales+=modulos.get(cont).getHoras();
        }
        return horasTotales;
    }
}
