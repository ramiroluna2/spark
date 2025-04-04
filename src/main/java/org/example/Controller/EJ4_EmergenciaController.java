package org.example.Controller;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Service.EJ4_EmergenciaService;

import java.util.Map;

public class EJ4_EmergenciaController {

    public static void initRoutes(){
        EJ4_EmergenciaService servicio = new EJ4_EmergenciaService();

        get("/emergencia", (req, res) -> {
            String tipo = req.queryParams("tipo");
            res.type("application/json");

            if (tipo == null || tipo.trim().isEmpty()) {
                res.status(400);
                return new ObjectMapper().writeValueAsString(
                        Map.of("error", "Debe enviar el parámetro 'tipo'")
                );
            }

            String telefono = servicio.getTelefono(tipo);

            if (telefono == null) {
                res.status(404);
                return new ObjectMapper().writeValueAsString(
                        Map.of("error", "No se encontró un número para ese tipo de emergencia")
                );
            }

            return new ObjectMapper().writeValueAsString(
                    Map.of("tipo", tipo.toLowerCase(), "telefono", telefono)
            );
        });
    }
}
