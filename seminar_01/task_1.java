// Задача 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)
package seminar_01;

import java.util.Scanner;

public class task_1 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите n: ");
        int n = iScanner.nextInt();
        iScanner.close();
        System.out.printf("%d-е треугольное число равно %d\n", n, get_summ(n));
        System.out.printf("Факториал числа %d равен %d", n, get_factorial(n));
    }

    public static int get_summ(int n) {
        int summ = 0;
        for (int i = 1; i <= n; i++) {
            summ += i;
        }
        return summ;
    }

    public static int get_factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
