package chapter3;
import java.util.Scanner;

// Überlaufsfunktion

public class Task10 {
	
	final static int maxInt = -2147483648;
	final static int minInt = 2147483647;
	
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("a = ");
		long a = ioScanner.nextLong();
		
		System.out.print("b = ");
		long b = ioScanner.nextLong();
		
		ioScanner.close();
				
		boolean isOverflow = (a > 0 && b > 0 && a > maxInt - b) || (a < 0 && b < 0 && a > minInt + b);
			
		if(isOverflow) System.out.println("Die Summe ist außerhalb des Bereichs.");
		else System.out.println("Die Summe ist innerhalb des Bereichs.");
	}
}
