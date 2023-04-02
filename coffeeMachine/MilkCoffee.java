package coffeeMachine;

public class MilkCoffee extends Coffee implements Chocable{
    private int milkRatio;

    public MilkCoffee (String name, double price, int volume, int milkRatio) {
        super(name, price, volume);
        this.milkRatio = milkRatio;
    }

    public int getMilkRatio() {
        return this.milkRatio;
    }

    public void addChocolate() {
        // Здесь инструкции для посыпки шоколадной крошкой:
    }

    @Override
    public String toString() {
        return super.toString() +
            ", milkRatio='" + getMilkRatio() + "'";
    }

        
}
