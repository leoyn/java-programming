package semester1.chapter4;
import java.util.Scanner;
import java.io.File;

public class Task6 {
	
	final static String FILE_PATH = "/statistics.txt";
	
	public static void main(String[] args) throws Exception {
		Scanner ioScanner = new Scanner(new File(FILE_PATH));
		
		if(ioScanner.hasNextInt()) {
			int value = ioScanner.nextInt();
			int min = value;
			int max = value;
			int sum = value;
			int i = 0;
			
			while(ioScanner.hasNextInt()) {
				value = ioScanner.nextInt();
				if(value > max) max = value;
				else if(value < min) min = value;
				
				sum += value;
				i++;
			}
			
			ioScanner.close();
			
			System.out.println("max = " + max + "; mid = " + sum/i + "; min = " + min);
		} else {
			System.out.println("Keine Werte in der Datei " + FILE_PATH);
		}
	}
}
