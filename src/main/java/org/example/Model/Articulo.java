package org.example.Model;

public class Articulo {
    private String codigo;
    private String descripcion;
    private double precioNeto;

    public Articulo(String codigo, String descripcion, double precioNeto) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioNeto = precioNeto;
    }

    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioNeto() { return precioNeto; }


}
