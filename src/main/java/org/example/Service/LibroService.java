package org.example.Service;

import org.example.Model.Libro;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LibroService {

    private List<Libro> libros;

    public LibroService() {
        libros = new ArrayList<>();
        cargarLibros();
    }

    private void cargarLibros(){
        libros.add(new Libro("Ficciones", "Jorge Luis Borges"));
        libros.add(new Libro("El Aleph", "Jorge Luis Borges"));
        libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez"));
        libros.add(new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez"));
        libros.add(new Libro("Rayuela", "Julio Cortázar"));
    }

    public List<String> getLibrosPorAutor(String autor) {
        return libros.stream()
                .filter(l -> l.getAutor().equalsIgnoreCase(autor))
                .map(Libro::getNombre)
                .collect(Collectors.toList());
    }

}
