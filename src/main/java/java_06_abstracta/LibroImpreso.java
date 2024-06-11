package java_06_abstracta;

public class LibroImpreso extends Libro {
    int numeroPaginas;

    public LibroImpreso(int fecha, String autor, String titulo, int numeroPaginas) {
        super(fecha, autor, titulo);
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String getInfo() {
        return "El libro tiene "+this.getNumeroPaginas()+" y es del autor "+this.getAutor();
    }

}
