package org.example.Service;

import org.example.Model.EJ7_Libro;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EJ7_LibroService {

    private List<EJ7_Libro> EJ7Libros;

    public EJ7_LibroService() {
        EJ7Libros = new ArrayList<>();
        cargarLibros();
    }

    private void cargarLibros(){
        EJ7Libros.add(new EJ7_Libro("Ficciones", "Jorge Luis Borges"));
        EJ7Libros.add(new EJ7_Libro("El Aleph", "Jorge Luis Borges"));
        EJ7Libros.add(new EJ7_Libro("Cien años de soledad", "Gabriel García Márquez"));
        EJ7Libros.add(new EJ7_Libro("El amor en los tiempos del cólera", "Gabriel García Márquez"));
        EJ7Libros.add(new EJ7_Libro("Rayuela", "Julio Cortázar"));
    }

    public List<String> getLibrosPorAutor(String autor) {
        return EJ7Libros.stream()
                .filter(l -> l.getAutor().equalsIgnoreCase(autor))
                .map(EJ7_Libro::getNombre)
                .collect(Collectors.toList());
    }

}
