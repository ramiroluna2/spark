package org.example.Controller;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Service.EJ8_TorneoService;

public class EJ8_TorneoController {
    public static void initRoutes() {
        EJ8_TorneoService EJ8TorneoService = new EJ8_TorneoService();
        ObjectMapper mapper = new ObjectMapper();

        get("/torneo/partidos", (req, res) -> {
            res.type("application/json");
            return mapper.writeValueAsString(EJ8TorneoService.getPartidos());
        });

        get("/torneo/equipo", (req, res) -> {
            String equipo = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(EJ8TorneoService.getPartidosEquipo(equipo));
        });

        get("/torneo/local", (req, res) -> {
            String equipo = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(EJ8TorneoService.getPartidosLocal(equipo));
        });

        get("/torneo/visitantePendientes", (req, res) -> {
            String equipo = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(EJ8TorneoService.getPartidosVisitantePendientes(equipo));
        });

        get("/torneo/ganados", (req, res) -> {
            String equipo = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(EJ8TorneoService.getCantidadGanados(equipo));
        });

        get("/torneo/goles", (req, res) -> {
            String equipo = req.queryParams("nombre");
            res.type("application/json");
            return mapper.writeValueAsString(EJ8TorneoService.getGolesConvertidos(equipo));
        });
    }
}
