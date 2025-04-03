package org.example.Controller;

import static spark.Spark.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Service.LibroService;

import java.util.List;
import java.util.Map;

public class LibroController {
    public static void initRoutes() {
        LibroService servicio = new LibroService();
        ObjectMapper mapper = new ObjectMapper();

        get("/libros", (req, res) -> {
            res.type("application/json");
            String autor = req.queryParams("autor");

            if (autor == null || autor.trim().isEmpty()) {
                res.status(400);
                return mapper.writeValueAsString(Map.of("error", "Debe enviar el parámetro 'autor'"));
            }

            List<String> libros = servicio.getLibrosPorAutor(autor);

            if (libros.isEmpty()) {
                res.status(404);
                return mapper.writeValueAsString(Map.of("mensaje", "No se encontraron libros para ese autor"));
            }

            return mapper.writeValueAsString(libros);
        });
    }
}