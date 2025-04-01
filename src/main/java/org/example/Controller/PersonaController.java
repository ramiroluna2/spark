package org.example.Controller;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Data.PersonaDAO;
import org.example.Model.Persona;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class PersonaController {

    public static void initRoutes() {
        PersonaDAO personaDAO = new PersonaDAO();
        ObjectMapper mapper = new ObjectMapper();

        get("/personas", (req, res) -> {
            res.type("application/json");
            return mapper.writeValueAsString(personaDAO.getPersonas());
        });

        get("/hijos", (req, res) -> {
            String nombre = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(personaDAO.getHijos(nombre));
        });

        get("/nietos", (req, res) -> {
            String nombre = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(personaDAO.getNietos(nombre));
        });
    }
}
