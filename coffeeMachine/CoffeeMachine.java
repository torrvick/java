package coffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> reciepsList;
    private double balance;
    private int totalWater;
    private int totalMilk;
    private boolean maitenanceMode;

    public CoffeeMachine() {
        this.reciepsList = new ArrayList<Coffee>();
        this.balance = 0;
        this.totalWater = 1000;
        this.totalMilk = 1000;
        this.maitenanceMode = false;
    }
    public CoffeeMachine addReceipe(Coffee receipe) {
        reciepsList.add(receipe);
        return this;
    }

    public void insertCoin(double coin) {
        balance += coin;
    }

    private int milkVolume(int value, int ratio) {
        return value/4*ratio;
    }

    public List<Coffee> getList() {
        return this.reciepsList;
    }

    public void sellCoffee(String name) {
        if (!maitenanceMode){
            for (Coffee coffee : reciepsList) {
                if (coffee.getName().equals(name)) {
                    if (this.balance > coffee.getPrice()) {
                        System.out.println("Вы купили " + coffee.getName());
                        this.balance -= coffee.getPrice();
                        if (coffee instanceof MilkCoffee) {
                            MilkCoffee item = (MilkCoffee)coffee;
                            this.totalWater -= item.getVolume() - milkVolume(item.getVolume(),item.getMilkRatio());
                            this.totalMilk -= milkVolume(item.getVolume(),item.getMilkRatio());
                        } else {
                            this.totalWater -= coffee.getVolume();
                        }

                        if (this.totalWater < 500 || this.totalMilk < 500) {
                            maitenanceMode = true;
                        }
                    } else {
                        System.out.println("Недостаточно средств");
                    }
                }
            }
        } else {
            System.out.println("Извините, аппарат вреенно не работает");
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
