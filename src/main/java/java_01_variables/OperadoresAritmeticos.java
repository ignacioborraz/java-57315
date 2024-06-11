package java_01_variables;

public class OperadoresAritmeticos {
    public static void main(String[] args) {
        int num1 = 1000;
        int num2 = 57;
        System.out.println(num1+num2);
        System.out.println(num1-num2);
        System.out.println(num1*num2);
        float resultadoDivision = (float) num1/num2;
        System.out.println(resultadoDivision);
        System.out.println(num1%num2);
        int num3 = num1++;
        // asigna 1000 y luego le suma 1 a 1000
        int num4 = ++num1;
        // suma 1 a 1001 y luego asigna
        System.out.println(num3);
        System.out.println(num4);
        int num5 = num2--;
        int num6 = --num2;
        System.out.println(num5);
        System.out.println(num6);
    }
}
