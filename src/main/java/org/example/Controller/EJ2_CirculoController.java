package org.example.Controller;

import static spark.Spark.*;

public class EJ2_CirculoController {

    public static void initRoutes() {
        get("/circulo",(req, res) -> {
            String radioParam = req.queryParams("radio");
            if (radioParam == null || radioParam.trim().isEmpty()) {
                res.status(400);
                return "Error: debe enviar el parámetro 'radio'";
            }

            try {
                double radio = Double.parseDouble(radioParam);

                if (radio <= 0) {
                    res.status(400);
                    return "Error: el radio debe ser mayor que 0";
                }

                double perimetro = 2 * Math.PI * radio;
                double area = Math.PI * radio * radio;

                return "Perimetro: " + perimetro + "\nArea: " + area;
            } catch (NumberFormatException e) {
                res.status(400);
                return "Error: el valor de 'radio' no es válido";
            }
        });
    }
}
