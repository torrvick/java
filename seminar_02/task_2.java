// Дана строка (получение через обычный текстовый файл!!!)
// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"
// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].

package seminar_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class task_2 {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static void readFile() throws IOException {
        File file = new File("seminar_02/students.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        for (String student = reader.readLine(); student!= null; student = reader.readLine()) {
            String[] grade = student.split(",");
            StringBuilder gradeText = new StringBuilder();
            gradeText.append("Студент ")
                    .append(grade[0].substring(grade[0].indexOf(":")+2, grade[0].length()-1))
                    .append(" получил ")
                    .append(grade[1].substring(grade[1].indexOf(":")+2, grade[1].length()-1))
                    .append(" по предмету ")
                    .append(grade[2].substring(grade[2].indexOf(":")+2, grade[2].length()-1));
            System.out.println(gradeText);
        }
        reader.close();
    }
}
