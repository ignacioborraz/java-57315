package java_01_variables;

public class OperadoresLogicos {
    public static void main(String[] args) {
        int num1 = 15;
        int num2 = 7;
        boolean resultado1 = (num1 > 0) && (num2 > 10);
        System.out.println(resultado1);
        boolean resultado2 = (num1 > 10) || (num2 > 100);
        System.out.println(resultado2);
        System.out.println(!resultado1);
        System.out.println(!resultado2);
        System.out.println(!true);
        System.out.println(!false);
    }
}
