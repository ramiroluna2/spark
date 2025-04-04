package org.example.Controller;

import static spark.Spark.*;

public class EJ1_PalindromoController {

    public static void initRoutes() {
        get("/palindromo", (req, res) -> {
            String palabra = req.queryParams("palabra");

            if (palabra == null || palabra.trim().isEmpty()) {
                res.status(400);
                return "Error: Debe ingresar una palabra con el parámetro 'palabra'";
            }

            String limpia = palabra.replaceAll("\\s+", "").toLowerCase();
            String invertida = new StringBuilder(limpia).reverse().toString();

            boolean esPalindromo = limpia.equals(invertida);
            return esPalindromo ? "Es palíndromo" : "No es palíndromo";
        });
    }
}