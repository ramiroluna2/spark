package org.example.Service;

import java.util.HashMap;
import java.util.Map;

public class EJ4_EmergenciaService {

    private final Map<String, String> telefonos;

    public EJ4_EmergenciaService() {
        this.telefonos = new HashMap<>();
        cargarTelefonos();
    }

    private void cargarTelefonos() {
        telefonos.put("policia", "911");
        telefonos.put("bomberos", "100");
        telefonos.put("ambulancia", "107");
        telefonos.put("violencia", "144");
    }

    public String getTelefono(String emergencia) {
        if (emergencia == null || emergencia.trim().isEmpty()) {
            return null;
        }
        return telefonos.get(emergencia.toLowerCase());
    }
}
