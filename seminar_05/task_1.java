// Задача 1. Реализуйте структуру телефонной книги с помощью HashMap, 
// учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции:
// 1) Добавление номера
// 2) Вывод всего
package seminar_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task_1 {

    static HashMap<String, ArrayList<String>> phonebook = new HashMap<String, ArrayList<String>>();
    static Scanner iScanner = new Scanner(System.in, "cp866");
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("Что Вы хотите сделать?\n1 - Добавить номер\n2 - Вывести весь справочник");
            String choice = iScanner.nextLine();
            if (choice.equals("1")) {
                addNumber();
            } else if (choice.equals("2")) {
                showAll();
            } else if (choice.equals("q")) {
                break;
            } else {
                System.out.println("Неверный ввод\n");
            }
        }
        iScanner.close();
    }
    
    static void addNumber() {
        System.out.println("Введите имя:");
        String name = iScanner.nextLine();
        System.out.println("Введите номер телефона:");
        String phone = iScanner.nextLine();
        ArrayList<String> numbers = new ArrayList<String>();
        String messageEnd = "добавлена\n";
        if (phonebook.containsKey(name)) {
            numbers = phonebook.get(name);
            messageEnd = "обновлена\n";
        }
        numbers.add(phone);
        phonebook.put(name, numbers);
        System.out.println("\nЗапись " + messageEnd);
        
    }

    static void showAll() {
        for (Map.Entry<String, ArrayList<String>> record: phonebook.entrySet()) {
            System.out.print(record.getKey() + ": ");
            for (String ph: record.getValue()) {
                System.out.print(ph + "\n" + " ".repeat(record.getKey().length()+2));
            }
            System.out.println();
        }
        
    }


    
}
