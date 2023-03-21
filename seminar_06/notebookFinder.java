package seminar_06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class notebookFinder {
    public static void main(String[] args) throws Exception {
        List<notebook> notebooks = getFromCSV("/seminar_06/laptops.csv");
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        for (notebook elem : notebooks) {
            if (elem.getColor().equals("Белый") && elem.getStorage() > 1000) System.out.println(elem);
        }
    }

    static List<notebook> getFromCSV(String fileName) throws Exception{
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

            notebook nb = new notebook();
            nb.setManufacture(manufacture);
            nb.setModel(model);
            nb.setScreenSize(screenSize);
            nb.setCpu(cpu);
            nb.setRam(ram);
            nb.setStorage(storage);
            nb.setOs(os);
            nb.setWeight(weight);

        notebooks.add(nb);
        }
        br.close();
        return notebooks;
    }

}