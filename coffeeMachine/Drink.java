package coffeeMachine;

public abstract class Drink extends Product implements Prepareable{
    
    private int volume;
    
    public int getVolume() {
        return this.volume;
    }

    public Drink(String name, double price, int volume) {
        super(name, price);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() +
            ", volume='" + getVolume();
    }
}
