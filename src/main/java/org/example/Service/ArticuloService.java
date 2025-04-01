package org.example.Service;

import org.example.Model.Articulo;

import java.util.HashMap;
import java.util.Map;

public class ArticuloService {

    private Map<String, Articulo> articulos;

    public ArticuloService() {
        articulos = new HashMap<>();
        cargarArticulos();

    }

    private void cargarArticulos() {
        articulos.put("A001", new Articulo("A001", "Mouse", 25000.0));
        articulos.put("A002", new Articulo("A002", "Teclado", 15000.0));
        articulos.put("A003", new Articulo("A003", "Monitor", 100000.0));
        articulos.put("A004", new Articulo("A004", "Impresora", 10000.0));
        articulos.put("A005", new Articulo("A005", "Pantalla", 10000.0));
    }

    public Articulo getArticulo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return null;
        }
        return articulos.get(codigo.toUpperCase());
    }
}
