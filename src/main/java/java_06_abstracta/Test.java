package java_06_abstracta;

public class Test {
    public static void main(String[] args) {
        try {
            Biblioteca biblioteca = new Biblioteca();
            Libro digital1 = new LibroDigital(2020, "Igna", "JAVA 1", 204.85);
            biblioteca.agregarLibro(digital1);
            //System.out.println(digital1.getTitulo());
            Libro digital2 = new LibroDigital(2024, "Fran", "El mundo de JAVA", 484.01);
            biblioteca.agregarLibro(digital2);
            //System.out.println(digital2.getAutor());
            //System.out.println(digital2.getInfo());
            Libro impreso1 = new LibroImpreso(2008, "Dios", "Descubriendo JAVA con Dios", 580);
            biblioteca.agregarLibro(impreso1);
            //System.out.println(impreso1.getTitulo());
            LibroImpreso impreso2 = new LibroImpreso(2000, "Gabriel", "Gabriel descubre JAVA", 251);
            biblioteca.agregarLibro(impreso2);
            //System.out.println(impreso2.getAutor());
            //System.out.println(impreso2.getInfo());
            for (Libro libro : biblioteca.mostrarLibros()) {
                System.out.println(libro.getTitulo());
            }
            System.out.println(biblioteca.buscarLibroPorTitulo("JAVA 1").getInfo());
            System.out.println(biblioteca.buscarLibroPorTitulo("JAVA").getInfo());
            //Libro libro = new Libro();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
