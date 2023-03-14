// Задача 2. Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
package seminar_04;

import java.util.LinkedList;
import java.util.Random;

public class task_2 {
    public static void main(String[] args) {
        LinkedList<Integer> intList = getRandList(10, 0, 10);
        System.out.printf("\nИсходный список:\n%s\n\n",intList);
        Random random = new Random();
        int randValue = random.nextInt(11);
        enqueue(intList, randValue);
        System.out.printf("Метод enqueue()\nПомещаем в конец очереди число %d\nРезультат:\n%s\n\n", randValue, intList);
        System.out.printf("Метод dequeue()\nВозвращаем первый элемент из очереди и удаляем его\nЭлемент: %d\nРезультат:\n%s\n\n", dequeue(intList), intList);
        System.out.printf("Метод first()\nВозвращаем первый элемент из очереди, не удаляя его\nЭлемент: %d\nРезультат:\n%s\n\n", first(intList), intList);
    }

    static void enqueue(LinkedList<Integer> list, int value) {
        list.add(value);
    }

    static int dequeue(LinkedList<Integer> list) {
        int value = list.getFirst();
        list.removeFirst();
        return value;
    }

    static int first(LinkedList<Integer> list) {
        return list.getFirst();
    }

    static LinkedList<Integer> getRandList(int size, int min, int max) {
        LinkedList<Integer> array = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(min, max + 1));
        }
        return array;
    }
}
