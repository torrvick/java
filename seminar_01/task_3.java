// Задача 3. Реализовать простой калькулятор
package seminar_01;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите a: ");
        int a = iScanner.nextInt();
        System.out.print("Введите символ операции: ");
        char op = iScanner.next().charAt(0);
        System.out.print("Введите b: ");
        int b = iScanner.nextInt();
        iScanner.close();
        System.out.printf("Результат вычисления равен %s", calc(a, b, op));
    }

    public static String calc(int a, int b, char op) {
        if (op == '+') return String.valueOf(a + b);
        if (op == '-') return String.valueOf(a - b);
        if (op == '*') return String.valueOf(a * b);
        if (op == '/') return String.valueOf((double)(a)/(double)(b));
        return "Ошибка вычисления";
    }
}
