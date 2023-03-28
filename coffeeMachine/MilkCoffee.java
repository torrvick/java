package coffeeMachine;

public class MilkCoffee extends Coffee {
    private int milkRatio;

    public MilkCoffee (String name, int volume, int temperature, double price, int milkRatio) {
        super(name, volume, temperature, price);
        this.milkRatio = milkRatio;
    }

    public int getMilkRatio() {
        return this.milkRatio;
    }

    @Override
    public String toString() {
        return super.toString() +
            ", milkRatio='" + getMilkRatio() + "'";
    }

        
}
