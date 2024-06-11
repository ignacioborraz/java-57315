package java_03_iterables;

public class Arrays {
    public static void main(String[] args) {
        char[] arrayDeLetras = {'a','b','c','d','e'};
        boolean[] arrayDeBooleanos = { true, false, true, true, true, true, false, true };
        System.out.println(arrayDeBooleanos.length);
        arrayDeBooleanos[3] = false;
        arrayDeBooleanos[arrayDeBooleanos.length-1] = false;
    }
}
