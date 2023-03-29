package coffeeMachine;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        CoffeeMachine machine = new CoffeeMachine();
        startMachine(machine);
        HashMap<Integer, Coffee> coffeeMap = machine.getList();
        StringBuilder outputString = new StringBuilder();
        for (HashMap.Entry<Integer, Coffee> item : coffeeMap.entrySet()){
            int id = item.getKey();
            Coffee coffee = item.getValue();
            outputString.append(String.format("%s: %-20s %5sмл - %6s р.\n", id, coffee.getName(), coffee.getVolume(), coffee.getPrice()));
        }
        Scanner in = new Scanner(System.in);
        while (true) {
            if (machine.isReady()) {
                mainMenu(machine, outputString.toString());
                System.out.print("Введите количество монет: ");
                String coins = in.nextLine();
                if (coins != "") {
                    machine.insertCoin(Integer.parseInt(coins));
                }
                mainMenu(machine, outputString.toString());
                System.out.print("Введите номер напитка: ");
                int CoffeeID = Integer.parseInt(in.nextLine());
                machine.sellCoffee(CoffeeID);
                
            } else {
                mainMenu(machine, outputString.toString());
                System.out.print("Извините, аппарат временно не работает");
                in.nextLine();
            }
        }
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
        machine.addReceipe(new Coffee("Американо большой", 400, 90, 100))
                .addReceipe(new Coffee("Американо маленький", 200, 90, 80))
                .addReceipe(new Coffee("Эспрессо", 50, 90, 150))
                .addReceipe(new MilkCoffee("Капучино большой", 400, 90, 120, 3))
                .addReceipe(new MilkCoffee("Капучино маленький", 200, 90, 100, 3))
                .addReceipe(new MilkCoffee("Маккиато большой", 400, 90, 150, 2))
                .addReceipe(new MilkCoffee("Маккиато маленький", 200, 90, 120, 2));
    }
}