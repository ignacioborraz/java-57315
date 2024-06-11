package java_05_herencia;

public class LibroImpreso extends Libro {
    private int numeroPaginas;

    public LibroImpreso() {}
    public LibroImpreso(String titulo, String autor, int fecha, int numeroPaginas) {
        super(titulo, autor, fecha);
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
