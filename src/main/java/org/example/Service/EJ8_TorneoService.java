package org.example.Service;

import org.example.Model.EJ8_Partido;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EJ8_TorneoService {
    private List<EJ8_Partido> EJ8Partidos = new ArrayList<>();

    public EJ8_TorneoService() {
        cargarPartidos();
    }

    private void cargarPartidos() {
        EJ8Partidos.add(new EJ8_Partido("River", "Boca", 2, 2, true));
        EJ8Partidos.add(new EJ8_Partido("River", "Racing", 0, 0, true));
        EJ8Partidos.add(new EJ8_Partido("River", "Aldosivi", 3, 1, true));
        EJ8Partidos.add(new EJ8_Partido("River", "Talleres", null, null, false));

        EJ8Partidos.add(new EJ8_Partido("Boca", "River", 1, 0, true));
        EJ8Partidos.add(new EJ8_Partido("Boca", "Independiente", 2, 1, true));
        EJ8Partidos.add(new EJ8_Partido("Boca", "Velez", null, null, false));
        EJ8Partidos.add(new EJ8_Partido("Boca", "Lanus", null, null, false));

        EJ8Partidos.add(new EJ8_Partido("Racing", "Independiente", 0, 1, true));
        EJ8Partidos.add(new EJ8_Partido("Racing", "Lanus", 2, 2, true));
        EJ8Partidos.add(new EJ8_Partido("Racing", "Talleres", null, null, false));
        EJ8Partidos.add(new EJ8_Partido("Racing", "Boca", null, null, false));

        EJ8Partidos.add(new EJ8_Partido("Independiente", "River", 0, 2, true));
        EJ8Partidos.add(new EJ8_Partido("Independiente", "Boca", 1, 1, true));
        EJ8Partidos.add(new EJ8_Partido("Independiente", "Lanus", null, null, false));
        EJ8Partidos.add(new EJ8_Partido("Independiente", "Velez", null, null, false));

        EJ8Partidos.add(new EJ8_Partido("Lanus", "River", 2, 3, true));
        EJ8Partidos.add(new EJ8_Partido("Lanus", "Boca", 1, 2, true));
        EJ8Partidos.add(new EJ8_Partido("Lanus", "Aldosivi", 1, 0, true));
        EJ8Partidos.add(new EJ8_Partido("Lanus", "Velez", null, null, false));

        EJ8Partidos.add(new EJ8_Partido("Velez", "Racing", 2, 2, true));
        EJ8Partidos.add(new EJ8_Partido("Velez", "Talleres", 0, 0, true));
        EJ8Partidos.add(new EJ8_Partido("Velez", "Boca", null, null, false));
        EJ8Partidos.add(new EJ8_Partido("Velez", "River", null, null, false));

        EJ8Partidos.add(new EJ8_Partido("Talleres", "Velez", 1, 1, true));
        EJ8Partidos.add(new EJ8_Partido("Talleres", "Aldosivi", 2, 0, true));
        EJ8Partidos.add(new EJ8_Partido("Talleres", "Independiente", null, null, false));
        EJ8Partidos.add(new EJ8_Partido("Talleres", "Lanus", null, null, false));

        EJ8Partidos.add(new EJ8_Partido("Aldosivi", "Boca", 0, 2, true));
        EJ8Partidos.add(new EJ8_Partido("Aldosivi", "Racing", 1, 3, true));
        EJ8Partidos.add(new EJ8_Partido("Aldosivi", "Independiente", null, null, false));
        EJ8Partidos.add(new EJ8_Partido("Aldosivi", "Talleres", null, null, false));
    }

    public List<EJ8_Partido> getPartidos() {
        return EJ8Partidos;
    }

    public List<EJ8_Partido> getPartidosEquipo(String equipo) {
        return EJ8Partidos.stream()
                .filter(p -> p.getLocal().equalsIgnoreCase(equipo) || p.getVisitante().equalsIgnoreCase(equipo))
                .collect(Collectors.toList());
    }

    public List<EJ8_Partido> getPartidosLocal(String equipo) {
        return EJ8Partidos.stream()
                .filter(p -> p.getLocal().equalsIgnoreCase(equipo) && p.isJugado())
                .collect(Collectors.toList());
    }

    public List<EJ8_Partido> getPartidosVisitantePendientes(String equipo) {
        return EJ8Partidos.stream()
                .filter(p -> p.getVisitante().equalsIgnoreCase(equipo) && !p.isJugado())
                .collect(Collectors.toList());
    }

    public long getCantidadGanados(String equipo) {
        return EJ8Partidos.stream()
                .filter(p -> p.isJugado() && (
                        (p.getLocal().equalsIgnoreCase(equipo) && p.getGolesLocal() > p.getGolesVisitante()) ||
                                (p.getVisitante().equalsIgnoreCase(equipo) && p.getGolesVisitante() > p.getGolesLocal())
                ))
                .count();
    }

    public int getGolesConvertidos(String equipo){
        return EJ8Partidos.stream()
                .filter(EJ8_Partido::isJugado)
                .mapToInt(p -> {
                    if (p.getLocal().equalsIgnoreCase(equipo)) return p.getGolesLocal();
                    if (p.getVisitante().equalsIgnoreCase(equipo)) return p.getGolesVisitante();
                    return 0;
                })
                .sum();
    }
}
