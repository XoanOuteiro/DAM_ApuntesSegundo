package com.example.listados_adaptadores;

public class Planeta {

    private int idFoto;
    private String nombre;

    public Planeta(String nombre, int id){

        this.idFoto = id;
        this.nombre = nombre;

    }

    public int getIdFoto() {
        return idFoto;
    }

    public String getNombre() {
        return nombre;
    }
}
