// Задача 3-4. В калькулятор добавьте возможность отменить последнюю операцию.
// + Каскадное удаление
package seminar_04;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class task_3_4 {
    public static void main(String[] args) {
        System.out.println("Вводите числа и арифметические операции");
        System.out.println("Для отмены последней операции нажмите c");
        System.out.println("Для выхода нажмите q");

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите a: ");
        Double a = iScanner.nextDouble();

        LinkedList<String> calcList = new LinkedList<>();

        while (true) {
            System.out.print("Введите символ операции: ");
            String nextInput = iScanner.next();

            if (nextInput.equals("q")) { break; }
            if (nextInput.equals("c")) {
                calcList.removeLast();
                try {
                    calcList.getLast();
                } catch (Exception e) {
                    if (e instanceof NoSuchElementException) {
                        System.out.println("Это была последняя операция");
                        break;
                    }
                }
                System.out.printf("Откат операции. Результат вычисления равен %.2f\n\n", Double.parseDouble(calcList.getLast()));
                a = Double.parseDouble(calcList.getLast());
                continue;
            }

            char op = nextInput.charAt(0);
            System.out.print("Введите b: ");
            Double b = iScanner.nextDouble();
            String result = calc(a, b, op);
            calcList.add(result);
            System.out.printf("Результат вычисления равен %.2f\n\n", Double.parseDouble(result));
            a = Double.parseDouble(result);
        }
        iScanner.close();
    }

    public static String calc(Double a, Double b, char op) {
        if (op == '+') return String.valueOf(a + b);
        if (op == '-') return String.valueOf(a - b);
        if (op == '*') return String.valueOf(a * b);
        if (op == '/') return String.valueOf(a/(double)(b));
        return "Ошибка вычисления";
    }
    
}
