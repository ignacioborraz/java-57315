package java_03_iterables;

import java.util.ArrayList;
import java.util.List;

public class EstructuraFor {
    public static void main(String[] args) {
        for (int i=1; i<=5; i++) {
            int calculo = (i+100)*2;
            System.out.println(i);
            System.out.println(calculo);
        }
        List<String> productos = new ArrayList<>();
        productos.add("aceite");
        productos.add("sal");
        productos.add("vinagre");
        for (int i=0; i<productos.size(); i++) {
            System.out.println("El producto se llama "+productos.get(i));
        }
        for (String producto : productos) {
            System.out.println("El producto iterado es: "+producto);
        }
    }
}
