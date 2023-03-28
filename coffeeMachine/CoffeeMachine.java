package coffeeMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {
    private HashMap<Integer, Coffee> reciepsList;
    private double balance;

    
    private int totalWater;
    private int totalMilk;
    private int id;
    private boolean maitenanceMode;

    public CoffeeMachine() {
        this.reciepsList = new HashMap<Integer, Coffee>();
        this.balance = 0;
        this.totalWater = 1000;
        this.totalMilk = 1000;
        this.id = 0;
        this.maitenanceMode = false;
    }
    public CoffeeMachine addReceipe(Coffee receipe) {
        // reciepsList.add(receipe);
        reciepsList.put(++id, receipe);
        return this;
    }

    public double getBalance() {
        return this.balance;
    }

    public void insertCoin(double coin) {
        balance += coin;
    }

    private int milkVolume(int value, int ratio) {
        return value/4*ratio;
    }

    public HashMap<Integer, Coffee> getList() {
        return this.reciepsList;
    }

    public void sellCoffee(String name) {
        if (!maitenanceMode){
            // for (Coffee coffee : reciepsList) {
            for (HashMap.Entry<Integer, Coffee> coffee: reciepsList.entrySet()){
                if (coffee.getValue().getName().equals(name)) {
                    if (this.balance > coffee.getValue().getPrice()) {
                        System.out.println("Вы купили " + coffee.getValue().getName());
                        this.balance -= coffee.getValue().getPrice();
                        if (coffee instanceof MilkCoffee) {
                            MilkCoffee item = (MilkCoffee)coffee;
                            this.totalWater -= item.getVolume() - milkVolume(item.getVolume(),item.getMilkRatio());
                            this.totalMilk -= milkVolume(item.getVolume(),item.getMilkRatio());
                        } else {
                            this.totalWater -= coffee.getValue().getVolume();
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
        // for (Coffee receipe : reciepsList) {
        for (HashMap.Entry<Integer, Coffee> receipe: reciepsList.entrySet()){
            outputString.append(receipe.getKey());
            outputString.append(": ");
            outputString.append(receipe.getValue());
            outputString.append("\n");
        }
        return outputString.toString();
    }


    
}
