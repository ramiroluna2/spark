package org.example.Controller;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Service.TorneoService;

public class TorneoController {
    public static void initRoutes() {
        TorneoService torneoService = new TorneoService();
        ObjectMapper mapper = new ObjectMapper();

        get("/torneo/partidos", (req, res) -> {
            res.type("application/json");
            return mapper.writeValueAsString(torneoService.getPartidos());
        });

        get("/torneo/equipo", (req, res) -> {
            String equipo = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(torneoService.getPartidosEquipo(equipo));
        });

        get("/torneo/local", (req, res) -> {
            String equipo = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(torneoService.getPartidosLocal(equipo));
        });

        get("/torneo/visitantePendientes", (req, res) -> {
            String equipo = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(torneoService.getPartidosVisitantePendientes(equipo));
        });

        get("/torneo/ganados", (req, res) -> {
            String equipo = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(torneoService.getCantidadGanados(equipo));
        });

        get("/torneo/goles", (req, res) -> {
            String equipo = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(torneoService.getGolesConvertidos(equipo));
        });
    }
}
