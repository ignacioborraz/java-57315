package java_05_herencia;

import java.util.Objects;

public class Libro {
    String titulo;
    String autor;
    int fecha;

    public Libro() {}

    public Libro(String titulo, String autor, int fecha) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return fecha == libro.fecha && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, fecha);
    }
}
