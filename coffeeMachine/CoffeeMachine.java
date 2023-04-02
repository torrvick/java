package coffeeMachine;

import java.util.HashMap;

public class CoffeeMachine {
    private HashMap<Integer, Coffee> productList;
    private double balance;
    private int totalWater;
    private int totalMilk;
    private int id;
    private boolean maitenanceMode;
    private String systemMessage;

    public CoffeeMachine() {
        this.productList = new HashMap<Integer, Coffee>();
        this.balance = 0;
        this.totalWater = 1000;
        this.totalMilk = 1000;
        this.id = 0;
        this.maitenanceMode = false;
        this.systemMessage = "";
    }
    public CoffeeMachine addProduct(Coffee receipe) {
        this.productList.put(++id, receipe);
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
        return this.productList;
    }

    public void sellProduct(int choice) {
        if (this.maitenanceMode) {
            this.systemMessage = "\nИзвините, аппарат временно не работает\n";
            return;
        }
        if (!productList.containsKey(choice)) {
            this.systemMessage = "\nНекорректный номер напитка\n";
            return;
        }
        Coffee product = productList.get(choice);
        if (this.balance < product.getPrice()) {
            this.systemMessage = "\nНедостаточно средств\n";
            return;
        }
        this.systemMessage = "\nВы купили " + product.getName() +"\n";
        product.prepare();
        this.balance -= product.getPrice();
        if (product instanceof MilkCoffee) {
            MilkCoffee item = (MilkCoffee)product;
            this.totalWater -= item.getVolume() - milkVolume(item.getVolume(),item.getMilkRatio());
            this.totalMilk -= milkVolume(item.getVolume(),item.getMilkRatio());
        } else {
            this.totalWater -= product.getVolume();
        }
        if (this.totalWater < 500 || this.totalMilk < 500) {
            this.maitenanceMode = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        for (HashMap.Entry<Integer, Coffee> product: productList.entrySet()){
            outputString.append(product.getKey());
            outputString.append(": ");
            outputString.append(product.getValue());
            outputString.append("\n");
        }
        return outputString.toString();
    }


    
}
