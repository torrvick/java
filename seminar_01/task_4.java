// Задача 4. Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.
package seminar_01;

import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = iScanner.nextLine();
        iScanner.close();
        
        String q = exp.substring(0, exp.indexOf('+')).trim();
        String w = exp.substring(exp.indexOf('+')+1, exp.indexOf('=')).trim();
        int e = Integer.parseInt(exp.substring(exp.indexOf('=')+1).trim());
        
        int hid = 0;

        if (q.charAt(0) == '?' && w.charAt(0) == '?') {
            if (e/10%2 == 0) { 
                hid = e/10/2; 
                q = hid + Character.toString(q.charAt(1));
                w = hid + Character.toString(w.charAt(1));
            }
            else { hid = -1; }
        } else if (q.charAt(1) == '?' && w.charAt(1) == '?') {
            if (e%10%2 == 0) {
                hid = e%10/2;
                q = Character.toString(q.charAt(0)) + hid;
                w = Character.toString(w.charAt(0)) + hid;
            }
            else { hid = -1; }
        } else if (q.charAt(0) == '?') {
            hid = e/10 - Integer.parseInt(Character.toString(w.charAt(0))); 
            q = hid + Character.toString(q.charAt(1));
            w = Character.toString(w.charAt(0)) + hid;
        } 
        else if (w.charAt(0) == '?') {
            hid = e/10 - Integer.parseInt(Character.toString(q.charAt(0)));
            q = Character.toString(q.charAt(0)) + hid;
            w = hid + Character.toString(w.charAt(1));
        }
        
        if (Integer.parseInt(q) + Integer.parseInt(w) == e && hid != -1) {
            System.out.printf("Восстановленное выражение: %s + %s = %s", q, w, e);
        } else {
            System.out.println("Решения не существует");
        }
    }
}
