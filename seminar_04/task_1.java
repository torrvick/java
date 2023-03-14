// Задача 1. Пусть дан LinkedList с несколькими элементами. 
// Реализуйте метод(не void), который вернет “перевернутый” список.
package seminar_04;

import java.util.LinkedList;
import java.util.Random;

public class task_1 {
    public static void main(String[] args) {
        LinkedList<Integer> intArray = getRandArray(10, 0, 10);
        System.out.printf("\nИсходный список:\n%s\n\n",intArray);
        LinkedList<Integer> reversedArray = listReverse(intArray);
        System.out.printf("Перевернутый список:\n%s\n\n",reversedArray);
    }

    static LinkedList<Integer> listReverse(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.add(i, list.getLast());
            list.pollLast();
        }
        return list;
    }

    static LinkedList<Integer> getRandArray(int size, int min, int max) {
        LinkedList<Integer> array = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(min, max + 1));
        }
        return array;
    }
}
