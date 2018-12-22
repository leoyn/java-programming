package chapter10.Task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static final String FILE_PATH = "artikel.txt";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner ioScanner = new Scanner(new File(FILE_PATH));

        while(ioScanner.hasNextLine()) {
            String[] properties = ioScanner.nextLine().split(" ");

            if(properties.length > 2) {
                int sum = 0;
                for(int i = 2; i < properties.length; i++) {
                    sum += Integer.parseInt(properties[i]);
                }

                Artikel artikel = new Artikel(Integer.parseInt(properties[0]), Float.parseFloat(properties[1]), sum);

                System.out.println(artikel.getArtikelNr() + " " + artikel.getUmsatz() + "€");
            }
        }

        ioScanner.close();
    }
}