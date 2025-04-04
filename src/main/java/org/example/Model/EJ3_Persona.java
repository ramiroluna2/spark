package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class EJ3_Persona {
    private String nombre;
    private String apellido;
    private List<EJ3_Persona> hijos;


    public EJ3_Persona(String nombre, String apellido) {
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
    public List<EJ3_Persona> getHijos() {
        return hijos;
    }
    public void agregarHijo(EJ3_Persona hijo) {
        this.hijos.add(hijo);
    }

}
