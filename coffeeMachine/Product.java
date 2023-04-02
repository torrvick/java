package coffeeMachine;

public abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
            return this.name;
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
            ", price='" + getPrice() + "'";
    }
}
