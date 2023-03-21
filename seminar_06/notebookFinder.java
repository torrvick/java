package seminar_06;

import java.io.BufferedReader;
import java.io.FileReader;

public class notebookFinder {
    public static void main(String[] args) throws Exception {
        String workDir = System.getProperty("user.dir");
        BufferedReader br = new BufferedReader(new FileReader(workDir.concat("/seminar_06/laptops.csv"))) ;
        String s;
        while((s=br.readLine())!=null){    
            System.out.println(s);
        }
    }
}