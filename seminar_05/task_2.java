// Задача 2. Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.
package seminar_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class task_2 {
    public static void main(String[] args) {
        ArrayList<String> people = getArray();
        HashMap<String, Integer> peopleCount = new HashMap<String, Integer>();
        for (String person : people) {
            person = person.split(" ")[0];
            if (peopleCount.containsKey(person)) {
                peopleCount.put(person, peopleCount.get(person) + 1);                
            } else {
                peopleCount.put(person, 1);
            }
        }

        List<Map.Entry<String, Integer>> peopleCountSorted = new ArrayList<>(peopleCount.entrySet());
        peopleCountSorted.sort(Map.Entry.comparingByValue());

        
        for (int i = peopleCountSorted.size() - 1; i >= 0; i--) {
            System.out.println(peopleCountSorted.get(i));
        }

    }
    
    static ArrayList<String> getArray() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Иван Иванов");
        list.add("Светлана Петрова");
        list.add("Кристина Белова");
        list.add("Анна Мусина");
        list.add("Анна Крутова");
        list.add("Иван Юрин");
        list.add("Петр Лыков");
        list.add("Павел Чернов");
        list.add("Петр Чернышов");
        list.add("Мария Федорова");
        list.add("Марина Светлова");
        list.add("Мария Савина");
        list.add("Мария Рыкова");
        list.add("Марина Лугова");
        list.add("Анна Владимирова");
        list.add("Иван Мечников");
        list.add("Петр Петин");
        list.add("Иван Ежов");
        return list;
    }
}
