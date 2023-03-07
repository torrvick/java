// Задание 3. Напишите метод, который принимает на вход строку (String) 
// и определяет является ли строка палиндромом (возвращает boolean значение)

package seminar_02;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in, "cp866");
        System.out.print("Введите строку: ");
        String inputString = iScanner.nextLine();
        iScanner.close();
        if (isPalindrome(inputString)) System.out.println("Эта строка - палиндром");
        else System.out.println("Эта строка - не является палиндромом");
    }

    public static boolean isPalindrome(String inputString) {
        inputString = inputString.toLowerCase().replaceAll(" ", "");
        for (int i = 0; i < inputString.length()/2; i++) {
            if (inputString.charAt(i) != inputString.charAt(inputString.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}
