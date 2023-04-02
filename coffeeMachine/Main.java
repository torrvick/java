package coffeeMachine;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        CoffeeMachine machine = new CoffeeMachine();
        startMachine(machine);
        HashMap<Integer, Coffee> productMap = machine.getList();
        StringBuilder outputString = new StringBuilder();
        for (HashMap.Entry<Integer, Coffee> item : productMap.entrySet()){
            int id = item.getKey();
            Coffee product = item.getValue();
            // outputString.append(String.format("%s: %-20s %5sмл - %6s р.\n", id, product.getName(), product.getVolume(), product.getPrice()));
            // System.out.println(product.prepare());
        }
        Scanner in = new Scanner(System.in);
        // while (true) {
        //     if (machine.isReady()) {
        //         mainMenu(machine, outputString.toString());
        //         System.out.print("Введите количество монет: ");
        //         String coins = in.nextLine();
        //         if (coins != "") {
        //             machine.insertCoin(Integer.parseInt(coins));
        //         }
        //         mainMenu(machine, outputString.toString());
        //         System.out.print("Введите номер товара: ");
        //         int productID = Integer.parseInt(in.nextLine());
        //         machine.sellProduct(productID);
                
        //     } else {
        //         mainMenu(machine, outputString.toString());
        //         System.out.print("Извините, аппарат временно не работает");
        //         in.nextLine();
        //     }
        // }
    }

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
                .addProduct(new MilkCoffee("Маккиато маленький", 120, 200, 2));
    }
}