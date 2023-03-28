package coffeeMachine;

public class Coffee {
    private String name;
    private int volume;
    private int temperature;
    private double price;

    public Coffee(String name, int volume, int temperature, double price) {
        this.name = name;
        this.volume = volume;
        this.temperature = temperature;
        this.price = price;
    }


    public String getName() {
        return this.name;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "name='" + getName() + "'" +
            ", volume='" + getVolume() + "'" +
            ", temperature='" + getTemperature() + "'" +
            ", price='" + getPrice() + "'";
    }


}
