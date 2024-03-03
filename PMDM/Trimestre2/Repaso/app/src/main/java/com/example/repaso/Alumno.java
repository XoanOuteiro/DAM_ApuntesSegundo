package com.example.repaso;

public class Alumno {

    /*

        ---Atributos

     */
    private String nombre;
    private String curso; //Puede ser ESO, BACH o Ciclos
    private String ciclo; //Puede ser DAM, DAW o ASIR

    /*

        ---Metodos constructores

     */
    public Alumno(String nombre, String curso, String ciclo){

        this.nombre = nombre;
        this.ciclo = ciclo;
        this.curso = curso;

    }

    public Alumno(String nombre, String curso){

        this.ciclo = null;
        this.nombre = nombre;
        this.curso = curso;

    }

    /*

        ---Getters & Setters

     */

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
}
