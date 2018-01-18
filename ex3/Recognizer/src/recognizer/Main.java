package recognizer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Recognizer rec = new Recognizer();
        try {
            Scanner s = new Scanner(System.in);
            String snum = s.next();
            String i = rec.recognize(snum);
            System.out.println(i);
            //i = rec.recognize("-123");
            //System.out.println(i);
            //Uncomment the lines below to see its effect...
            //i = rec.recognize("123A");
            //i = rec.recognize("NCC1701");
        } catch (NumberFormatException ex) {
            //ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
