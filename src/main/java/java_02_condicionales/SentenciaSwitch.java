package java_02_condicionales;

import java.util.Scanner;

public class SentenciaSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el día");
        String dia = sc.nextLine();
        switch (dia) {
            case "lunes":
                System.out.println("Es el primer dia de la semana");
                break;
            case "martes":
                System.out.println("Es el día más pesado de la semana");
                break;
            case "miercoles":
                System.out.println("Estamos a la mitad");
                break;
            default:
                System.out.println("No reconozco el dia");
                break;
        }
    }
}
