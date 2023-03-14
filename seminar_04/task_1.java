// Задача 1. Пусть дан LinkedList с несколькими элементами. 
// Реализуйте метод(не void), который вернет “перевернутый” список.
package seminar_04;

import java.util.LinkedList;
import java.util.Random;

public class task_1 {
    public static void main(String[] args) {
        LinkedList<Integer> intList = getRandList(10, 0, 10);
        System.out.printf("\nИсходный список:\n%s\n\n",intList);
        LinkedList<Integer> reversedList = listReverse(intList);
        System.out.printf("Перевернутый список:\n%s\n\n",reversedList);
    }

    static LinkedList<Integer> listReverse(LinkedList<Integer> list) {
        LinkedList<Integer> reversedList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            reversedList.add(list.get(list.size()-i-1));
        }
        return reversedList;
    }

    static LinkedList<Integer> getRandList(int size, int min, int max) {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(min, max + 1));
        }
        return list;
    }
}
