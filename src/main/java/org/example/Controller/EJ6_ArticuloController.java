package org.example.Controller;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.EJ6_Articulo;
import org.example.Service.EJ6_ArticuloService;

import java.util.Map;


public class EJ6_ArticuloController {
    public static void initRoutes() {
        EJ6_ArticuloService servicio = new EJ6_ArticuloService();
        ObjectMapper mapper = new ObjectMapper();

        get("/articulo", (req, res) -> {
            String codigo = req.queryParams("codigo");
            res.type("application/json");

            if (codigo == null || codigo.trim().isEmpty()) {
                res.status(400);
                return mapper.writeValueAsString(Map.of("error", "Debe enviar el codigo"));

            }

            EJ6_Articulo EJ6Articulo = servicio.getArticulo(codigo);

            if (EJ6Articulo == null) {
                res.status(404);
                return mapper.writeValueAsString(Map.of("error", "Artículo no encontrado"));
            }

            double iva = EJ6Articulo.getPrecioNeto() * 0.21;
            double total = EJ6Articulo.getPrecioNeto() + iva;

            Map<String, Object> respuesta = Map.of(
                    "codigo", EJ6Articulo.getCodigo(),
                    "descripcion", EJ6Articulo.getDescripcion(),
                    "precioNeto", EJ6Articulo.getPrecioNeto(),
                    "iva", Math.round(iva * 100.0) / 100.0,
                    "total", Math.round(total * 100.0) / 100.0
            );

            return mapper.writeValueAsString(respuesta);
        });
    }
}
