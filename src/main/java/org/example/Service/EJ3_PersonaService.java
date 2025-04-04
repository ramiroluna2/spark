package org.example.Service;

import org.example.Model.EJ3_Persona;

import java.util.List;
import java.util.ArrayList;

public class EJ3_PersonaService {
    private List<EJ3_Persona> EJ3Personas;

    public EJ3_PersonaService() {
        this.EJ3Personas = new ArrayList<>();
        cargarDatos();
    }

    private void cargarDatos() {
        // Crear personas
        EJ3_Persona juana = new EJ3_Persona("Juana", "Perez");
        EJ3_Persona carlos = new EJ3_Persona("Carlos", "Perez");
        EJ3_Persona lucia = new EJ3_Persona("Lucia", "Perez");
        EJ3_Persona tomas = new EJ3_Persona("Tomas", "Perez");
        EJ3_Persona sofia = new EJ3_Persona("Sofia", "Perez");

        // Establecer relaciones
        carlos.agregarHijo(tomas);
        lucia.agregarHijo(sofia);
        juana.agregarHijo(carlos);
        juana.agregarHijo(lucia);

        // Lista plana: agregamos a todos
        EJ3Personas.add(juana);

    }

    public List<EJ3_Persona> getPersonas() {
        return EJ3Personas;
    }

    public List<EJ3_Persona> getHijos(String nombre) {
        EJ3_Persona EJ3Persona = EJ3Personas.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);

        return (EJ3Persona != null) ? EJ3Persona.getHijos() : new ArrayList<>();
    }

    public List<EJ3_Persona> getNietos(String nombre) {
        EJ3_Persona EJ3Persona = EJ3Personas.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);

        List<EJ3_Persona> nietos = new ArrayList<>();
        if (EJ3Persona != null) {
            for (EJ3_Persona hijo : EJ3Persona.getHijos()) {
                nietos.addAll(hijo.getHijos());
            }
        }
        return nietos;
    }
}