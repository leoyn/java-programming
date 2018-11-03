package chapter5;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// Resistor calculator

public class Task3 {
	/*
	 * EBNF Grammar:
	 * Digit = "0"|"1"|"2"|"3"|"4"|"5"|"6"|"7"|"8"|"9".
	 * Number = Digit {Digit}.
	 * SumOfResistors = Number {( "+" Number ) | ( "|" Number)}.
	 */
	final static String FILE_PATH = "/resistors.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner ioScanner = new Scanner(new File(FILE_PATH));
		
		if(ioScanner.hasNextLine()) {
			String[] verticalResistors = ioScanner.nextLine().replaceAll(" ", "").split("\\+");
			ioScanner.close();
			
			double sum = 0;
			
			for(String item : verticalResistors) {
				String[] horizontalResistors = item.split("\\|");
				
				if(horizontalResistors.length > 1) {
					for(String resistor : horizontalResistors) {
						sum += 1 / (double) Integer.parseInt(resistor);
					}
				} else sum += Integer.parseInt(horizontalResistors[0]);
			}
			
			System.out.println("∑R = " + sum);
		} else System.out.println("File is empty");
	}
}
