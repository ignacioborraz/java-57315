package java_05_herencia;

public class LibroDigital extends Libro {
    private double peso;

    public LibroDigital() {}
    public LibroDigital(String titulo, String autor, int fecha, double peso) {
        super(titulo, autor, fecha);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
