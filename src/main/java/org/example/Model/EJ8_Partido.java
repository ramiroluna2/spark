package org.example.Model;



public class EJ8_Partido {
    private String local;
    private String visitante;
    private Integer goleslocal;
    private Integer golesvisitante;
    private boolean jugado;

    public EJ8_Partido(String local, String visitante, Integer goleslocal, Integer golesvisitante, boolean jugado) {
        this.local = local;
        this.visitante = visitante;
        this.goleslocal = goleslocal;
        this.golesvisitante = golesvisitante;
        this.jugado = jugado;
    }

    public String getLocal() { return local; }
    public String getVisitante() { return visitante; }
    public Integer getGolesLocal() { return goleslocal; }
    public Integer getGolesVisitante() { return golesvisitante; }
    public boolean isJugado() { return jugado; }
}
