package java_05_herencia;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    public Biblioteca() {
        this.libros = new ArrayList<>();
    }
    public void agregarLibro(Libro libroNuevo) throws Exception {
        for (Libro cadaUno: libros) {
            if (cadaUno.equals(libroNuevo)) {
                Exception error = new Exception("El libro ya existe en la biblioteca");
                throw error;
            }
        }
        libros.add(libroNuevo);
        System.out.println("Se creó el libro correctamente");
    }
    public void mostrarLibros() {
        // busquen la forma de pasar uno o mas parametros para que además el método realice un filtro
        // filtro por autor, por nombre, por año
        for (Libro cadaLibro : libros) {
            System.out.println(cadaLibro.titulo+" - "+cadaLibro.autor);
        }
    }
    public Libro buscarLibroPorTitulo(String titulo) throws Exception {
        for (Libro libro : libros) {
            if(libro.getTitulo()==titulo) {
                System.out.println("Se encontró "+titulo);
                return libro;
            }
        }
        throw new Exception("El libro no existe");
    }
    public static void main(String[] args) {
        try {
            Biblioteca biblioteca = new Biblioteca();
            Libro digital1 = new LibroDigital("Digital 1", "Igna", 2023, 200.9);
            biblioteca.agregarLibro(digital1);
            Libro digital2 = new LibroDigital("Digital 2", "Igna", 2024, 157.6);
            biblioteca.agregarLibro(digital2);
            Libro impreso1 = new LibroImpreso("Impreso 1", "Fran", 2022, 261);
            biblioteca.agregarLibro(impreso1);
            //biblioteca.agregarLibro(impreso1);
            Libro impreso2 = new LibroImpreso("Impreso 2", "Fran", 2023, 648);
            biblioteca.agregarLibro(impreso2);
            //biblioteca.agregarLibro(impreso2);
            biblioteca.mostrarLibros();
            biblioteca.buscarLibroPorTitulo("Digital 1");
            biblioteca.buscarLibroPorTitulo("Digital");
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
