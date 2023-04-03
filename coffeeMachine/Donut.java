package coffeeMachine;

public class Donut extends Food implements Heateable, Chocable{
    
    public Donut(String name, double price) {
        super(name, price);
    }

    public void heat() {
        // Здесь инструкции для разогрева поничка:
        // Поместить под тэн, включить тэн на 20 секунд
    }

    public void addChocolate() {
        // Здесь инструкции для посыпки шоколадной крошкой
    }

    
}
