package chapter4;
import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("x = ");
		int x = ioScanner.nextInt();
		
		ioScanner.close();
		
		int sumOfNumber = 0;
		
		while(x != 0) {
			sumOfNumber += x % 10;
			x = x / 10;
		}
		
		System.out.println("Die Ziffernsumme von x ist " + sumOfNumber);
	}
}
