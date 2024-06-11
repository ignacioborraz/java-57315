package java_06_abstracta;

public class LibroDigital extends Libro {
    private double pesoArchivo;

    public LibroDigital(int fecha, String autor, String titulo, double pesoArchivo) {
        super(fecha, autor, titulo);
        this.pesoArchivo = pesoArchivo;
    }

    public double getPesoArchivo() {
        return pesoArchivo;
    }

    public void setPesoArchivo(double pesoArchivo) {
        this.pesoArchivo = pesoArchivo;
    }

    public String getInfo() {
        return "El libro se llama "+this.getTitulo()+" y pesa "+this.getPesoArchivo();
    }

}
