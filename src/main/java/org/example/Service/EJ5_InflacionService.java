package org.example.Service;

public class EJ5_InflacionService {
    private static final double TASA_MENSUAL = 0.06;

    public double calcularInflacion(double cantidad, int meses) {
        return cantidad * Math.pow(1 + TASA_MENSUAL, meses);
    }

    public int convertirPlazoAMeses(String plazo) {
        plazo = plazo.toLowerCase().trim();

        if (plazo.contains("año")){
            String num = plazo.replaceAll("[^0-9]", "");
            return Integer.parseInt(num) * 12;

        } else if (plazo.contains("mes")){
            return Integer.parseInt(plazo.replaceAll("[^0-9]", ""));
        }
        return 0;
    }

}
