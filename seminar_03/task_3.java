// Задача 2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка.
package seminar_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class task_3 {
    public static void main(String[] args) {
        ArrayList<Integer> intArray = getRandArray(10, 0, 10);
        System.out.printf("\nИсходный список: \n%s\n\n", intArray);
        System.out.printf("Минимальное значение: %d\n", getMin(intArray));
        System.out.printf("Максимальное значение: %d\n", getMax(intArray));
        System.out.printf("Среднее значение: %.2f\n\n", getAvg(intArray));
    }

    static ArrayList<Integer> getRandArray(int size, int min, int max) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(min, max));
        }
        return array;
    }

    static Integer getMin(ArrayList<Integer> array) {
        Iterator<Integer> iter = array.iterator();
        int minElem = iter.next();
        while(iter.hasNext()) {
            int currentElem = iter.next();
            if (currentElem < minElem) minElem = currentElem;
        } 
        return minElem;      
    }

    static Integer getMax(ArrayList<Integer> array) {
        Iterator<Integer> iter = array.iterator();
        int maxElem = iter.next();
        while(iter.hasNext()) {
            int currentElem = iter.next();
            if (currentElem > maxElem) maxElem = currentElem;
        } 
        return maxElem;      
    }

    static Double getAvg(ArrayList<Integer> array) {
        Iterator<Integer> iter = array.iterator();
        int avg = iter.next();
        while(iter.hasNext()) {
            avg += iter.next();
        } 
        return (double)avg / array.size();      
    }
}
