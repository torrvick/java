package seminar_06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    static public List<notebook> getFromCSV(String fileName) throws Exception{
        String workDir = System.getProperty("user.dir");
        BufferedReader br = new BufferedReader(new FileReader(workDir.concat(fileName))) ;
        String noteLine;
        List<notebook> notebooks = new ArrayList<>();
        while((noteLine=br.readLine())!=null){  
            String noteArr[] = noteLine.split(";"); 

            String manufacture = noteArr[0];
            String model = noteArr[1];
            double screenSize = Double.parseDouble(noteArr[2]);
            String cpu = noteArr[3];
            int ram = Integer.parseInt(noteArr[4]);
            int storage = Integer.parseInt(noteArr[5]);
            String os = noteArr[6];
            double weight = Double.parseDouble(noteArr[7]);
            String color = noteArr[8];

            notebook nb = new notebook();
            nb.setManufacture(manufacture);
            nb.setModel(model);
            nb.setScreenSize(screenSize);
            nb.setCpu(cpu);
            nb.setRam(ram);
            nb.setStorage(storage);
            nb.setOs(os);
            nb.setWeight(weight);
            nb.setColor(color);

        notebooks.add(nb);
        }
        br.close();
        return notebooks;
    }

    static public List<notebook> filter(List<notebook> notebooks, HashMap<String,String> params) throws Exception {
        List<notebook> filtered = new ArrayList<>();
        for (notebook elem : notebooks) {
            boolean checked = true;
            for (Map.Entry<String, String> param : params.entrySet()) {
                switch (param.getKey()) {
                    case "manufacture": checked &= elem.getManufacture().toLowerCase().contains(param.getValue().toLowerCase()); break;
                    case "screenSize": checked &= (elem.getScreenSize() >= Double.parseDouble(param.getValue())); break;
                    case "cpu": checked &= (elem.getCpu().toLowerCase().contains(param.getValue().toLowerCase())); break;
                    case "ram": checked &= (elem.getRam() >= Integer.parseInt(param.getValue())); break;
                    case "storage": checked &= (elem.getStorage() >= Integer.parseInt(param.getValue())); break;
                    case "os": checked &= elem.getOs().toLowerCase().contains(param.getValue().toLowerCase()); break;
                    case "weight": checked &= (elem.getWeight() <= Double.parseDouble(param.getValue())); break;
                    case "color": checked &= elem.getColor().toLowerCase().contains(param.getValue().toLowerCase()); break;
                }
            }
            if (checked) filtered.add(elem);
        }
        return filtered;
    }

}
