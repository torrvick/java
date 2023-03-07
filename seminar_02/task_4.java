// Задача 4.*дополнительно. К калькулятору из предыдущего дз добавить логирование
package seminar_02;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_4 {
    public static void main(String[] args) throws IOException {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите a: ");
        int a = iScanner.nextInt();
        System.out.print("Введите символ операции: ");
        char op = iScanner.next().charAt(0);
        System.out.print("Введите b: ");
        int b = iScanner.nextInt();
        iScanner.close();
        System.out.printf("Результат вычисления равен %s", calc(a, b, op));

        Logger logger = Logger.getLogger(task_1.class.getName());
        String workDir = System.getProperty("user.dir");
        FileHandler fHandler = new FileHandler(workDir.concat("/seminar_02/task_4.log"), true);
        logger.addHandler(fHandler);
        logger.setUseParentHandlers(false);
        SimpleFormatter sFormat = new SimpleFormatter();
        fHandler.setFormatter(sFormat);
    }

    public static String calc(int a, int b, char op) {
        if (op == '+') return String.valueOf(a + b);
        if (op == '-') return String.valueOf(a - b);
        if (op == '*') return String.valueOf(a * b);
        if (op == '/') return String.valueOf((double)(a)/(double)(b));
        return "Ошибка вычисления";
    }
}