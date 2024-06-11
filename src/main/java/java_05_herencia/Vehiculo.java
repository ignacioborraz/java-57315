package java_05_herencia;

import java.util.Objects;

public class Vehiculo {
    private int puertas;
    private String motor;

    public Vehiculo() {}
    public Vehiculo(int puertas, String motor) {
        this.puertas = puertas;
        this.motor = motor;
    }

    public int getPuertas() {
        return puertas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return puertas == vehiculo.puertas && Objects.equals(motor, vehiculo.motor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(puertas, motor);
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

}
class Prueba {
    public static void main(String[] args) {
        Vehiculo auto1 = new Vehiculo(4,"v8");
        Vehiculo auto2 = new Vehiculo(4,"v8");
        Vehiculo camion = new Vehiculo();
        camion.setMotor("v15");
        camion.setPuertas(2);
        System.out.println(auto1.hashCode());
        System.out.println(auto2.hashCode());
        System.out.println(auto1.equals(auto2));
        System.out.println(camion.getMotor());
    }
}