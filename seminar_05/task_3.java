// Задача 3. На шахматной доске расставить 8 ферзей так,
// чтобы они не били друг друга. И вывести Доску.
package seminar_05;

import java.util.Random;

public class task_3 {
    public static void main(String[] args) {
        char[][] desk = new char[8][8];
        desk = genDesk(desk);
        placeQueens(desk, 1);
        printDesk(desk);
    }

    static char[][] genDesk(char[][] desk) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                desk[i][j] = 'O';
            }
        }
        Random col = new Random();
        desk[0][col.nextInt(8)] = 'X';
        return desk;
    }

    static void printDesk(char[][] desk) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(desk[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isClean(int row, int col, char[][] desk) {
        for (int i = 0; i < row; i++) {
            if (desk[i][col] == 'X') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (desk[i][j] == 'X') {
                return false;
            }
        }

        for (int i = row, j = col; i >=0 && j < desk.length; i--, j++) {
            if (desk[i][j] == 'X') {
                return false;
            }
        }

        return true;
    }

    static boolean placeQueens(char[][] desk, int row) {
        if (row == desk.length) {
            return true;
        }

        for (int col = 0; col < desk.length; col++) {
            if (isClean(row, col, desk)) {
                desk[row][col] = 'X';
                if (placeQueens(desk, row + 1)) {
                    return true;
                }
                desk[row][col] = 'O';
            }
        }
        return false;
    }
}
