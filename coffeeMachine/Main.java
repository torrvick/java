package coffeeMachine;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.addReceipe(new Coffee("Американо большой", 400, 90, 100))
                .addReceipe(new Coffee("Американо маленький", 200, 90, 80))
                .addReceipe(new Coffee("Эспрессо", 50, 90, 150))
                .addReceipe(new MilkCoffee("Капучино большой", 400, 90, 120, 3))
                .addReceipe(new MilkCoffee("Капучино маленький", 200, 90, 100, 3))
                .addReceipe(new MilkCoffee("Маккиато большой", 400, 90, 150, 2))
                .addReceipe(new MilkCoffee("Маккиато маленький", 200, 90, 120, 2));
        
        System.out.println(machine);
        System.out.println();
        machine.sellCoffee("yu");
       
    }
}