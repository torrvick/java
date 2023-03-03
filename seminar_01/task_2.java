// Задача 2. Вывести все простые числа от 1 до 1000
package seminar_01;

public class task_2 {

  public static void main(String[] args) {
    int col_count = 0;
    for (int i = 2; i <= 1000; i++) {
      if (is_simple(i)) {
        System.out.printf("%5d", i);
        col_count++;
      }
      if (col_count == 10) {
        System.out.print("\n");
        col_count = 0;
      }
    }
  }

  public static boolean is_simple(int n) {
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }
}
