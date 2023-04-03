package coffeeMachine;

public class Tea extends Drink{

    public Tea(String name, double price, int volume) {
        super(name, price, volume);
    }

    public void prepare() {
        // Здесь инструкции для приготовления чая:
        // Взять нужный чай, залить кипятком
    }

}
