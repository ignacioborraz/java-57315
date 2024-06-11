package java_04_class;

public class Vivir {
    public static void main(String[] args) {
        Mutante xavier = new Mutante();
        xavier.nombre = "Xavier";
        xavier.edad = 50;
        xavier.energia = 100;
        xavier.comer(20);
        xavier.entrenar(20,2);
        System.out.println(Mutante.EDAD_APARICION_MUTACION);
        System.out.println(xavier.energia);
        Mutante magneto = new Mutante();
        magneto.setNombre("Magneto");
        magneto.setEnergia(200);
        magneto.setEdad(50);
        magneto.comer(50);
        System.out.println(magneto.getEnergia());
        Gato batata = new Gato();
        batata.nombre = "batata";
        System.out.println(batata.nombre);
        batata.setColor("rojo");
        System.out.println(batata.getColor());
    }
}
