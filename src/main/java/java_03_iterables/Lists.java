package java_03_iterables;

import java_04_class.Gato;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(12);
        numeros.add(120);
        numeros.add(1200);
        numeros.add(12000);
        System.out.println("El ultimo numero es: "+ numeros.get(numeros.size()-1));
        numeros.set(2,100);
        System.out.println(numeros);
        numeros.remove(0);
        System.out.println(numeros);
        List<Integer> numerosAagregar = new ArrayList<>();
        numerosAagregar.add(15);
        numerosAagregar.add(150);
        numerosAagregar.add(100);
        numeros.addAll(numerosAagregar);
        System.out.println(numeros);
        List<Integer> numerosAquitar = new ArrayList<>();
        numerosAquitar.add(15);
        numerosAquitar.add(12000);
        numeros.removeAll(numerosAquitar);
        System.out.println(numeros);
        Gato stela = new Gato();
        //stela.nombre = "stela";
        //stela.peso = 10;
    }
}
