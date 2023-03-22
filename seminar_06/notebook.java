package seminar_06;

public class notebook {
    private String manufacture;
    private String model;
    private double screenSize;
    private String cpu;
    private int ram;
    private int storage;
    private String os;
    private double weight;
    private String color;


    public notebook() {
    }

    public notebook(String manufacture, String model, double screenSize, String cpu, int ram, int storage, String os, double weight, String color) {
        this.manufacture = manufacture;
        this.model = model;
        this.screenSize = screenSize;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.weight = weight;
        this.color = color;
    }

    public String getManufacture() {
        return this.manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getScreenSize() {
        return this.screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getCpu() {
        return this.cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return this.ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return this.storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getOs() {
        return this.os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "{" +
            " manufacture='" + getManufacture() + "'" +
            ", model='" + getModel() + "'" +
            ", screenSize='" + getScreenSize() + "'" +
            ", cpu='" + getCpu() + "'" +
            ", ram='" + getRam() + "'" +
            ", storage='" + getStorage() + "'" +
            ", os='" + getOs() + "'" +
            ", weight='" + getWeight() + "'" +
            ", color='" + getColor() + "'" +
            " }";
    }

}
