package java_01_variables;

import java.util.Scanner;

public class OperadoresRelacionales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer numero");
        int num1 = sc.nextInt();
        System.out.println("Ingrese el segundo numero");
        int num2 = sc.nextInt();
        System.out.println(num1 == num2);
        System.out.println(num1 != num2);
        System.out.println(num1 < num2);
        System.out.println(num1 <= num2);
        System.out.println(num1 > num2);
        System.out.println(num1 >= num2);
    }
}
