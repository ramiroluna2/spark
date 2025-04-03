package org.example.Controller;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Service.PersonaService;

public class PersonaController {

    public static void initRoutes() {
    PersonaService personaService = new PersonaService();
        ObjectMapper mapper = new ObjectMapper();

        get("/personas", (req, res) -> {
            res.type("application/json");
            return mapper.writeValueAsString(personaService.getPersonas());
        });

        get("/hijos", (req, res) -> {
            String nombre = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(personaService.getHijos(nombre));
        });

        get("/nietos", (req, res) -> {
            String nombre = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(personaService.getNietos(nombre));
        });
    }
}
