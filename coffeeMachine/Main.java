package coffeeMachine;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        CoffeeMachine machine = new CoffeeMachine();
        startMachine(machine);
        HashMap<Integer, Product> productMap = machine.getList();
        StringBuilder outputString = new StringBuilder();
        for (HashMap.Entry<Integer, Product> item : productMap.entrySet()){
            int id = item.getKey();
            Product product = item.getValue();
            if (product instanceof Drink) {
                Drink drink = (Drink) product;
                outputString.append(String.format("%2s: %-22s %5sмл - %5s р.\n", id, drink.getName(), drink.getVolume(), drink.getPrice()));
            }
            if (product instanceof Food) {
                // Drink drink = (Drink) product;
                outputString.append(String.format("%2s: %-29s  - %5s р.\n", id, product.getName(), product.getPrice()));
            }
            // System.out.println(product.prepare());
        }
        Scanner in = new Scanner(System.in);

        while (true) {
            if (!machine.isReady()) {
                mainMenu(machine, outputString.toString());
                System.out.print("Извините, аппарат временно не работает");
                break;
            }

            mainMenu(machine, outputString.toString());
            System.out.print("Введите количество монет: ");
            String coins = in.nextLine();
            if (coins != "") {
                machine.insertCoin(Integer.parseInt(coins));
            }
            mainMenu(machine, outputString.toString());
            System.out.print("Введите номер товара: ");
            int productID = Integer.parseInt(in.nextLine());
            Product product = productMap.get(productID);
            machine.sellProduct(productID);

            if (product instanceof Prepareable) {
                    machine.prepareProduct(product);
                    System.out.println("Готовим...");
                }
            
            if (product instanceof Heateable) {
                // mainMenu(machine, outputString.toString());
                System.out.print("Желаете разогреть? Y/n:");
                String answer = in.nextLine();
                if (answer == "" || answer.startsWith("Y")) {
                    machine.heatProduct(product);
                    System.out.println("Разогреваем...");
                }
            }

            if (product instanceof Chocable) {
                // mainMenu(machine, outputString.toString());
                System.out.print("Желаете добавить шоколада? Y/n:");
                String answer = in.nextLine();
                if (answer == "" || answer.startsWith("Y")) {
                    machine.chocoProduct(product);
                    System.out.println("Добавляем шоколад...");
                }
            }
            System.out.println("Вы купили " + product.getName());
            System.out.println("Нажмите Enter чтобы продолжить");
            in.nextLine();
        }
    }

    // private static vois heatM

    private static void mainMenu(CoffeeMachine machine, String body) throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("В наличии есть следующие напитки: \n");
        System.out.println(body);
        System.out.println();
        System.out.printf("Текущий баланс: %s\n", machine.getBalance());
        System.out.printf("Остаток воды: %sмл\n", machine.getTotalWater());
        System.out.printf("Остаток молока: %sмл\n", machine.getTotalMilk());
        System.out.println(machine.getSystemMessage());
    }

    private static void startMachine(CoffeeMachine machine) {
        machine.addProduct(new Coffee("Американо большой", 100, 400))
                .addProduct(new Coffee("Американо маленький", 80, 200))
                .addProduct(new Coffee("Эспрессо", 150, 50))
                .addProduct(new MilkCoffee("Капучино большой", 120, 400, 3))
                .addProduct(new MilkCoffee("Капучино маленький",100, 200, 3))
                .addProduct(new MilkCoffee("Маккиато большой", 150, 400, 2))
                .addProduct(new MilkCoffee("Маккиато маленький", 120, 200, 2))
                .addProduct(new Tea("Чай черный большой", 100, 400))
                .addProduct(new Tea("Чай черный маленький", 70, 200))
                .addProduct(new Tea("Чай зеленый большой", 100, 400))
                .addProduct(new Tea("Чай зеленый маленький", 70, 200))
                .addProduct(new Donut("Пончик", 150))
                .addProduct(new Donut("Пончик с вишней", 180));
    }
}