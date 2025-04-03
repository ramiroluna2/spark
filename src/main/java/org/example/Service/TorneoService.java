package org.example.Service;

import org.example.Model.Partido;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TorneoService {
    private List<Partido> partidos = new ArrayList<>();

    public TorneoService() {
        cargarPartidos();
    }

    private void cargarPartidos() {
        partidos.add(new Partido("River", "Boca", 2, 2, true));
        partidos.add(new Partido("River", "Racing", 0, 0, true));
        partidos.add(new Partido("River", "Aldosivi", 3, 1, true));
        partidos.add(new Partido("River", "Talleres", null, null, false));

        partidos.add(new Partido("Boca", "River", 1, 0, true));
        partidos.add(new Partido("Boca", "Independiente", 2, 1, true));
        partidos.add(new Partido("Boca", "Velez", null, null, false));
        partidos.add(new Partido("Boca", "Lanus", null, null, false));

        partidos.add(new Partido("Racing", "Independiente", 0, 1, true));
        partidos.add(new Partido("Racing", "Lanus", 2, 2, true));
        partidos.add(new Partido("Racing", "Talleres", null, null, false));
        partidos.add(new Partido("Racing", "Boca", null, null, false));

        partidos.add(new Partido("Independiente", "River", 0, 2, true));
        partidos.add(new Partido("Independiente", "Boca", 1, 1, true));
        partidos.add(new Partido("Independiente", "Lanus", null, null, false));
        partidos.add(new Partido("Independiente", "Velez", null, null, false));

        partidos.add(new Partido("Lanus", "River", 2, 3, true));
        partidos.add(new Partido("Lanus", "Boca", 1, 2, true));
        partidos.add(new Partido("Lanus", "Aldosivi", 1, 0, true));
        partidos.add(new Partido("Lanus", "Velez", null, null, false));

        partidos.add(new Partido("Velez", "Racing", 2, 2, true));
        partidos.add(new Partido("Velez", "Talleres", 0, 0, true));
        partidos.add(new Partido("Velez", "Boca", null, null, false));
        partidos.add(new Partido("Velez", "River", null, null, false));

        partidos.add(new Partido("Talleres", "Velez", 1, 1, true));
        partidos.add(new Partido("Talleres", "Aldosivi", 2, 0, true));
        partidos.add(new Partido("Talleres", "Independiente", null, null, false));
        partidos.add(new Partido("Talleres", "Lanus", null, null, false));

        partidos.add(new Partido("Aldosivi", "Boca", 0, 2, true));
        partidos.add(new Partido("Aldosivi", "Racing", 1, 3, true));
        partidos.add(new Partido("Aldosivi", "Independiente", null, null, false));
        partidos.add(new Partido("Aldosivi", "Talleres", null, null, false));
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public List<Partido> getPartidosEquipo(String equipo) {
        return partidos.stream()
                .filter(p -> p.getLocal().equalsIgnoreCase(equipo) || p.getVisitante().equalsIgnoreCase(equipo))
                .collect(Collectors.toList());
    }

    public List<Partido> getPartidosLocal(String equipo) {
        return partidos.stream()
                .filter(p -> p.getLocal().equalsIgnoreCase(equipo) && p.isJugado())
                .collect(Collectors.toList());
    }

    public List<Partido> getPartidosVisitantePendientes(String equipo) {
        return partidos.stream()
                .filter(p -> p.getVisitante().equalsIgnoreCase(equipo) && !p.isJugado())
                .collect(Collectors.toList());
    }

    public long getCantidadGanados(String equipo) {
        return partidos.stream()
                .filter(p -> p.isJugado() && (
                        (p.getLocal().equalsIgnoreCase(equipo) && p.getGolesLocal() > p.getGolesVisitante()) ||
                                (p.getVisitante().equalsIgnoreCase(equipo) && p.getGolesVisitante() > p.getGolesLocal())
                ))
                .count();
    }

    public int getGolesConvertidos(String equipo){
        return partidos.stream()
                .filter(Partido::isJugado)
                .mapToInt(p -> {
                    if (p.getLocal().equalsIgnoreCase(equipo)) return p.getGolesLocal();
                    if (p.getVisitante().equalsIgnoreCase(equipo)) return p.getGolesVisitante();
                    return 0;
                })
                .sum();
    }
}
