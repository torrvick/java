// Задача 1. Реализовать алгоритм сортировки слиянием
package seminar_03;

import java.util.Arrays;
import java.util.Random;

public class task_1 {
    public static void main(String[] args) {
        int[] array = getRandArray(20, 0, 10);
        System.out.printf("\nИсходный массив: \n%s\n\n", Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.printf("\nОтсортированный массив: \n%s\n\n", Arrays.toString(array));
    }
    
    static int[] getRandArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(min, max + 1);
        }
        return array;
    }

    static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
        
    static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) temp[k++] = array[i++];
            else temp[k++] = array[j++];
        }
        
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        
        while (j <= right) {
            temp[k++] = array[j++];
        }
        
        for (i = left; i <= right; i++) {
            array[i] = temp[i - left];
        }
    }
}
