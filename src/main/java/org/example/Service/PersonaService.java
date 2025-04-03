package org.example.Service;

import org.example.Model.Persona;

import java.util.List;
import java.util.ArrayList;

public class PersonaService {
    private List<Persona> personas;

    public PersonaService() {
        this.personas = new ArrayList<>();
        cargarDatos();
    }

    private void cargarDatos() {
        // Crear personas
        Persona juana = new Persona("Juana", "Perez");
        Persona carlos = new Persona("Carlos", "Perez");
        Persona lucia = new Persona("Lucia", "Perez");
        Persona tomas = new Persona("Tomas", "Perez");
        Persona sofia = new Persona("Sofia", "Perez");

        // Establecer relaciones
        carlos.agregarHijo(tomas);
        lucia.agregarHijo(sofia);
        juana.agregarHijo(carlos);
        juana.agregarHijo(lucia);

        // Lista plana: agregamos a todos
        personas.add(juana);
        personas.add(carlos);
        personas.add(lucia);
        personas.add(tomas);
        personas.add(sofia);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public List<Persona> getHijos(String nombre) {
        Persona persona = personas.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);

        return (persona != null) ? persona.getHijos() : new ArrayList<>();
    }

    public List<Persona> getNietos(String nombre) {
        Persona persona = personas.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);

        List<Persona> nietos = new ArrayList<>();
        if (persona != null) {
            for (Persona hijo : persona.getHijos()) {
                nietos.addAll(hijo.getHijos());
            }
        }
        return nietos;
    }
}