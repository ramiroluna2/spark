package org.example.Controller;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.Articulo;
import org.example.Service.ArticuloService;

import java.util.Map;


public class ArticuloController {
    public static void initRoutes() {
        ArticuloService servicio = new ArticuloService();
        ObjectMapper mapper = new ObjectMapper();

        get("/articulo", (req, res) -> {
            String codigo = req.queryParams("codigo");
            res.type("application/json");

            if (codigo == null || codigo.trim().isEmpty()) {
                res.status(400);
                return mapper.writeValueAsString(Map.of("error", "Debe enviar el codigo"));

            }

            Articulo articulo = servicio.getArticulo(codigo);

            if (articulo == null) {
                res.status(404);
                return mapper.writeValueAsString(Map.of("error", "Artículo no encontrado"));
            }

            double iva = articulo.getPrecioNeto() * 0.21;
            double total = articulo.getPrecioNeto() + iva;

            Map<String, Object> respuesta = Map.of(
                    "codigo", articulo.getCodigo(),
                    "descripcion", articulo.getDescripcion(),
                    "precioNeto", articulo.getPrecioNeto(),
                    "iva", Math.round(iva * 100.0) / 100.0,
                    "total", Math.round(total * 100.0) / 100.0
            );

            return mapper.writeValueAsString(respuesta);
        });
    }
}
