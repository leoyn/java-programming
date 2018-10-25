package chapter3;
import java.util.Scanner;

public class Task10 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("a = ");
		long a = ioScanner.nextLong();
		
		System.out.print("b = ");
		long b = ioScanner.nextLong();
		
		ioScanner.close();
		
		long sum = a + b;
		
		if(sum < -2147483648 || sum > 2147483647) System.out.println("Die Summe ist außerhalb des Bereichs.");
		else System.out.println("Die Summe ist innerhalb des Bereichs.");
	}
}
