package java_04_class;

import org.w3c.dom.ls.LSOutput;

public class Mutante {
    int edad;
    String nombre;
    int energia;
    static final int EDAD_APARICION_MUTACION = 12;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        //System.out.println(valor);
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    void comer (int valor) {
        energia = energia + valor;
    }
    void entrenar(int valor, int cantidad) {
        energia = energia - valor * cantidad;
    }

}

