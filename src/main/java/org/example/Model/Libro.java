package org.example.Model;

public class Libro {

    public String nombre;
    public String autor;

    public Libro (String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getAutor(){
        return this.autor;
    }

}
