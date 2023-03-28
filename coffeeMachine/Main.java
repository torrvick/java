package coffeeMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        CoffeeMachine machine = new CoffeeMachine();
        machine.addReceipe(new Coffee("Американо большой", 400, 90, 100))
                .addReceipe(new Coffee("Американо маленький", 200, 90, 80))
                .addReceipe(new Coffee("Эспрессо", 50, 90, 150))
                .addReceipe(new MilkCoffee("Капучино большой", 400, 90, 120, 3))
                .addReceipe(new MilkCoffee("Капучино маленький", 200, 90, 100, 3))
                .addReceipe(new MilkCoffee("Маккиато большой", 400, 90, 150, 2))
                .addReceipe(new MilkCoffee("Маккиато маленький", 200, 90, 120, 2));
        
        // System.out.println(machine);
        // System.out.println();
        // machine.insertCoin(400);
        // machine.sellCoffee("Маккиато большой");
        HashMap<Integer, Coffee> coffeeList = machine.getList();
        System.out.println("В наличии есть следующие напитки: \n");
        StringBuilder outputString = new StringBuilder();
        for (HashMap.Entry<Integer, Coffee> item: coffeeList.entrySet()){
            // System.out.printf("%s: %-20s %5sмл - %6s р.\n", item.getKey(), item.getValue().getName(), item.getValue().getVolume(), item.getValue().getPrice());
            outputString.append(String.format("%s: %-20s %5sмл - %6s р.\n", item.getKey(), item.getValue().getName(), item.getValue().getVolume(), item.getValue().getPrice()));
        }
        System.out.println(outputString);
        System.out.println();
        System.out.printf("Текущий баланс: %s\n", machine.getBalance());
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество монет: ");
        int coins = in.nextInt();
        machine.insertCoin(coins);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println(outputString);
        System.out.println();
        System.out.printf("Текущий баланс: %s", machine.getBalance());

        // System.out.println(coffeeList.get(2));
    }

    private static void mainMenu() {
        
    }
}