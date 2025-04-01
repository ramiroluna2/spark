package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private List<Persona> hijos;


    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.hijos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public List<Persona> getHijos() {
        return hijos;
    }
    public void agregarHijo(Persona hijo) {
        this.hijos.add(hijo);
    }

}
