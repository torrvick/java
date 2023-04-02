package coffeeMachine;

public abstract class Food extends Product implements Heateable{

    public Food(String name, double price) {
        super(name, price);
    }

}
