package org.example.Controller;

import static spark.Spark.*;

import org.example.Service.EJ5_InflacionService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.HashMap;

public class EJ5_InflacionController {
    public static void initRoutes() {
        EJ5_InflacionService servicio = new EJ5_InflacionService();
        ObjectMapper mapper = new ObjectMapper();

        get("/inflacion", (req, res) -> {
            String montoParam = req.queryParams("monto");
            String plazoParam = req.queryParams("plazo");

            res.type("application/json");

            if (montoParam == null || plazoParam == null) {
                res.status(400);
                return mapper.writeValueAsString(Map.of("error", "Debe enviar 'monto' y 'plazo'"));
            }

            try {
                double monto = Double.parseDouble(montoParam);
                int meses = servicio.convertirPlazoAMeses(plazoParam);
                double ajustado = servicio.calcularInflacion(monto, meses);


                Map<String, Object> resultado = new HashMap<>();
                resultado.put("montoOriginal", monto);
                resultado.put("plazoEnMeses", meses);
                resultado.put("montoAjustado", Math.round(ajustado * 100.0) / 100.0);

                return mapper.writeValueAsString(resultado);

            } catch (NumberFormatException e) {
                res.status(400);
                return mapper.writeValueAsString(Map.of("error", "Parámetro 'monto' inválido"));
            }
        });
    }
}
