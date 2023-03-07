// Задача 1. Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.
package seminar_02;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_1 {
    public static void main(String[] args) throws IOException{
        int[] randArray = getRandArray(10, 0, 10);
        System.out.printf("%nИсходный массив:%n%s%n%n", Arrays.toString(randArray));
        System.out.printf("Отсортированный массив:\n%s%n%n", Arrays.toString(bubbleSort(randArray)));
    }

    public static int[] getRandArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(min, max + 1);
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) throws IOException {
        Logger logger = Logger.getLogger(task_1.class.getName());
        String workDir = System.getProperty("user.dir");
        FileHandler fHandler = new FileHandler(workDir.concat("/seminar_02/task_1.log"));
        logger.addHandler(fHandler);
        logger.setUseParentHandlers(false);
        SimpleFormatter sFormat = new SimpleFormatter();
        fHandler.setFormatter(sFormat);
        String logString = "";

        for (int i = 0; i < array.length-1; i++) {
            for(int j = 0; j < array.length-i-1; j++) {
                if(array[j + 1] < array[j]) {
                    logString = Arrays.toString(array) + "\npos(" + j + ") => pos(" + String.valueOf(j+1) + ")   :   " + array[j] + " => " + array[j+1] + "\n"; 
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else {
                    logString = Arrays.toString(array) + "\nНет перестановок\n";
                }
                logger.info(logString);
            }
        }
        return array;
    }

}
