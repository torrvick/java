package coffeeMachine;

import java.util.HashMap;

public class CoffeeMachine {
    private HashMap<Integer, Coffee> reciepsList;
    private double balance;
    private int totalWater;
    private int totalMilk;
    private int id;
    private boolean maitenanceMode;
    private String systemMessage;

    public CoffeeMachine() {
        this.reciepsList = new HashMap<Integer, Coffee>();
        this.balance = 0;
        this.totalWater = 1000;
        this.totalMilk = 1000;
        this.id = 0;
        this.maitenanceMode = false;
        this.systemMessage = "";
    }
    public CoffeeMachine addReceipe(Coffee receipe) {
        this.reciepsList.put(++id, receipe);
        return this;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getTotalWater() {
        return this.totalWater;
    }

    public int getTotalMilk() {
        return this.totalMilk;
    }

    public String getSystemMessage() {
        return this.systemMessage;
    }

    public void insertCoin(double coin) {
        this.balance += coin;
    }

    public boolean isReady() {
        return !this.maitenanceMode;
    }

    private int milkVolume(int value, int ratio) {
        return value/4*ratio;
    }

    public HashMap<Integer, Coffee> getList() {
        return this.reciepsList;
    }

    public void sellCoffee(int choice) {
        if (this.maitenanceMode) {
            this.systemMessage = "\nИзвините, аппарат временно не работает\n";
            return;
        }
        if (!reciepsList.containsKey(choice)) {
            this.systemMessage = "\nНекорректный номер напитка\n";
            return;
        }
        Coffee coffee = reciepsList.get(choice);
        if (this.balance < coffee.getPrice()) {
            this.systemMessage = "\nНедостаточно средств\n";
            return;
        }
        this.systemMessage = "\nВы купили " + coffee.getName() +"\n";
        this.balance -= coffee.getPrice();
        if (coffee instanceof MilkCoffee) {
            MilkCoffee item = (MilkCoffee)coffee;
            this.totalWater -= item.getVolume() - milkVolume(item.getVolume(),item.getMilkRatio());
            this.totalMilk -= milkVolume(item.getVolume(),item.getMilkRatio());
        } else {
            this.totalWater -= coffee.getVolume();
        }
        if (this.totalWater < 500 || this.totalMilk < 500) {
            this.maitenanceMode = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        for (HashMap.Entry<Integer, Coffee> receipe: reciepsList.entrySet()){
            outputString.append(receipe.getKey());
            outputString.append(": ");
            outputString.append(receipe.getValue());
            outputString.append("\n");
        }
        return outputString.toString();
    }


    
}
