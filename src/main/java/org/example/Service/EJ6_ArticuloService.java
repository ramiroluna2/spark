package org.example.Service;

import org.example.Model.EJ6_Articulo;

import java.util.HashMap;
import java.util.Map;

public class EJ6_ArticuloService {

    private Map<String, EJ6_Articulo> articulos;

    public EJ6_ArticuloService() {
        articulos = new HashMap<>();
        cargarArticulos();

    }

    private void cargarArticulos() {
        articulos.put("A001", new EJ6_Articulo("A001", "Mouse", 25000.0));
        articulos.put("A002", new EJ6_Articulo("A002", "Teclado", 15000.0));
        articulos.put("A003", new EJ6_Articulo("A003", "Monitor", 100000.0));
        articulos.put("A004", new EJ6_Articulo("A004", "Impresora", 10000.0));
        articulos.put("A005", new EJ6_Articulo("A005", "Pantalla", 10000.0));
    }

    public EJ6_Articulo getArticulo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return null;
        }
        return articulos.get(codigo.toUpperCase());
    }
}
