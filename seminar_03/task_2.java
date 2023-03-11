// Задача 2. Пусть дан произвольный список целых чисел, удалить из него чётные числа
package seminar_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class task_2 {
    public static void main(String[] args) {
        ArrayList<Integer> intArray = getRandArray(20, 0, 10);
        System.out.printf("\nИсходный список: \n%s\n\n", intArray);
        removeEven(intArray);
        System.out.printf("Список без чётных чисел: \n%s\n\n", intArray);
    }

    static ArrayList<Integer> getRandArray(int size, int min, int max) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(min, max));
        }
        return array;
    }

    static void removeEven(ArrayList<Integer> array) {
        Iterator<Integer> iter = array.iterator();
        while(iter.hasNext()){
            if (iter.next() % 2 == 0) {
                iter.remove();
            }
        }
    }
}
