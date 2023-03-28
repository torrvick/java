package coffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> reciepsList;
    private double balance;
    private int totalWater;
    private int totalMilk;

    public CoffeeMachine() {
        this.reciepsList = new ArrayList<Coffee>();
        balance = 0;
        totalWater = 100000;
        totalMilk = 10000;
    }
    public CoffeeMachine addReceipe(Coffee receipe) {
        reciepsList.add(receipe);
        return this;
    }

    public void insertCoin(double coin) {
        balance += coin;
    }

    private int milkCalc(int value, int ratio) {
        return value/4*ratio;
    }

    public void sellCoffee(String name) {
        for (Coffee coffee : reciepsList) {
            if (coffee.getName().equals(name)) {
                if (balance > coffee.getPrice()) {
                    System.out.println("Вы купили " + coffee.getName());
                    
                } else {
                    System.out.println("Недостаточно средств");
                }
                // if (coffee instanceof MilkCoffee) {
                //     MilkCoffee item = (MilkCoffee)coffee;
                    
                // }
            }
            
        }
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        for (Coffee receipe : reciepsList) {
            outputString.append(receipe);
            outputString.append("\n");
        }

        return outputString.toString();
    }


    
}
