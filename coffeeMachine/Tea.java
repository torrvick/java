package coffeeMachine;

public class Tea extends Drink{

    public Tea(String name, double price, int volume) {
        super(name, price, volume);
    }

    private void makeTea() {
        // Здесь инструкции для приготовления чая:
        // Взять нужный чай, залить кипятком
    }

    public void prepare() {
        makeTea();
    }
}
