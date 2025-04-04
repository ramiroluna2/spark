package org.example.Controller;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Service.EJ3_PersonaService;

public class EJ3_PersonaController {

    public static void initRoutes() {
    EJ3_PersonaService EJ3PersonaService = new EJ3_PersonaService();
        ObjectMapper mapper = new ObjectMapper();

        get("/personas", (req, res) -> {
            res.type("application/json");
            return mapper.writeValueAsString(EJ3PersonaService.getPersonas());
        });

        get("/hijos", (req, res) -> {
            String nombre = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(EJ3PersonaService.getHijos(nombre));
        });

        get("/nietos", (req, res) -> {
            String nombre = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(EJ3PersonaService.getNietos(nombre));
        });
    }
}
