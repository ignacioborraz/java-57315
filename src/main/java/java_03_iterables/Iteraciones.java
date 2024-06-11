package java_03_iterables;

public class Iteraciones {
    public static void main(String[] args) {
        int edad = 18;
        while (edad < 21) {
            System.out.println("No puedes pasar del primer loop");
            System.out.println(edad);
            edad++;
        }
        System.out.println("Se ejecuta luego");
        do {
            System.out.println("No puedes pasar del segundo loop");
            System.out.println(edad);
            edad++;
        } while (edad < 21);
        System.out.println("Se terminó la iteración");
    }
}
