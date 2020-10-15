package com.edemartini.dogram.pojo;

public class Mascota {

    //Variables
    private int foto;//Foto de la mascota
    private String nombre;//Nombre de la mascota
    private int rate;//Rate de la mascota

    //Método constructor solo con foto y nombre
    public Mascota(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
    }

    //Método constructor solo foto y rate
    public Mascota(int foto, int rate){
        this.foto = foto;
        this.rate = rate;
    }

    //Método constructor con todas las variables
    public Mascota(int foto, String nombre, int rate) {
        this.foto = foto;
        this.nombre = nombre;
        this.rate = rate;
    }

    //Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getFoto() { return foto; }
    public void setFoto(int foto) { this.foto = foto; }
    public int getRate() { return rate; }
    public void setRate(int rate) { this.rate = rate; }
}
