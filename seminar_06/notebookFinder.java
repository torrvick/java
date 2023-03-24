package seminar_06;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class notebookFinder {
    public static final int ROWS_PER_PAGE = 10;
    public static Scanner iScanner = new Scanner(System.in, "cp866");

    public static void main(String[] args) throws Exception {
        mainMenu();
        iScanner.close();
    }

    static void showFiltered(List<notebook> notebooks, HashMap<String,String> params, String header) throws Exception{
        List<notebook> filtered = notebook.filter(notebooks, params);
        int rowsCount = 0;
        clearScreen();
        String tableHeader = String.format("%-10s %-23s %-7s %-30s %-5s %-6s %-10s %-6s %-10s",
                                    "Марка",
                                            "Модель",
                                            "Экран",
                                            "Процессор",
                                            "ОЗУ",
                                            "Диск",
                                            "ОС",
                                            "Вес",
                                            "Цвет");
        System.out.println(header + tableHeader);
        for (notebook elem : filtered) {
            System.out.printf("%-10s %-23s %-7s %-30s %-5s %-6s %-10s %-6s %-10s\n", 
                                        elem.getManufacture(), 
                                        elem.getModel(), 
                                        elem.getScreenSize(), 
                                        elem.getCpu(), 
                                        elem.getRam(), 
                                        elem.getStorage(), 
                                        elem.getOs(), 
                                        elem.getWeight(), 
                                        elem.getColor());
            rowsCount++;
            if (rowsCount == ROWS_PER_PAGE) {
                System.out.println();
                System.out.print("Для показа следующей страницы нажмите Enter: ");
                System.out.println();
                iScanner.nextLine();
                clearScreen();
                System.out.println(header + tableHeader);
                rowsCount = 0;
            }
        }
    }

    static void mainMenu() throws Exception{
        List<notebook> notebooks = notebook.getFromCSV("/seminar_06/laptops.csv");
        HashMap<String,String> params = new HashMap<String,String>();

        String header = "Выбранные фильтры:\n";
        String message = "Вводите параметры. Для пропуска параметра нажмите Enter\n";

        String manufacture = nextFilter(header, message + "Производитель: ");
        if (manufacture != "") {
            header += "Производитель: \u001B[34m" + manufacture + "\u001B[0m\n";
            params.put("manufacture", manufacture);
        }
        String screenSize = nextFilter(header, message + "Минимальный размер экрана: ");
        if (screenSize != "") {
            header += "Минимальный размер экрана: \u001B[34m" + screenSize + "\u001B[0m\n";
            params.put("screenSize", screenSize);
        }
        String cpu = nextFilter(header, message + "Процессор: ");
        if (cpu != "") {
            header += "Процессор: \u001B[34m" + cpu + "\u001B[0m\n";
            params.put("cpu", cpu);
        }
        String ram = nextFilter(header, message + "Минимальное количество памяти: ");
        if (ram != "") {
            header += "Минимальное количество памяти: \u001B[34m" + ram + "\u001B[0m\n";
            params.put("ram", ram);
        }
        String storage = nextFilter(header, message + "Минимальный объем диска: ");
        if (storage != "") {
            header += "Минимальный объем диска: \u001B[34m" + storage + "\u001B[0m\n";
            params.put("storage", storage);
        }
        String os = nextFilter(header, message + "Операционная система: ");
        if (os != "") {
            header += "Операционная система: \u001B[34m" + os + "\u001B[0m\n";
            params.put("os", os);
        }
        String weight = nextFilter(header, message + "Максимальный вес: ");
        if (weight != "") {
            header += "Максимальный вес: \u001B[34m" + weight + "\u001B[0m\n";
            params.put("weight", weight);
        }
        String color = nextFilter(header, message + "Цвет: ");
        if (color != "") {
            header += "Цвет: \u001B[34m" + color + "\u001B[0m\n";
            params.put("color", color);
        }
        header += "\n";
        showFiltered(notebooks, params, header);
    }

    static void clearScreen() throws Exception{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    static String nextFilter(String header, String message) throws Exception{
        clearScreen();
        System.out.println(header);
        System.out.print(message);
        String param = iScanner.nextLine();
        return param;
    }
}