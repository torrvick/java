package coffeeMachine;

public class Coffee extends Drink{
    
    public Coffee(String name, double price, int volume) {
        super(name, price, volume);
    }

    private void makeCoffee() {
        // Здесь инструкции для приготовления кофе:
        // Намолоть зерна, разогреть воду, приготовить под давлением
    }

    public void prepare() {
        makeCoffee(); 
    }

}
