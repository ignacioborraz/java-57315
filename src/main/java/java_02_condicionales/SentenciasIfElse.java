package java_02_condicionales;

import java.util.Scanner;

public class SentenciasIfElse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su edad");
        int edad = sc.nextInt();
        if (edad > 18 && edad <= 35) {
            System.out.println("Podes entrar al boliche");
        } else if (edad <= 18) {
            System.out.println("Sos menor de edad, no podes entrar!");
        } else {
            System.out.println("Pasaste la edad máxima para ingresar");
        }
    }
}
