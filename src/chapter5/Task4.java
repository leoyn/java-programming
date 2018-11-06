package chapter5;
import java.util.Scanner;

// Interest table

public class Task4 {
	public static void main(String[] args) {
		
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("Capital: ");
		double capital = ioScanner.nextDouble();
		
		System.out.print("Interest (in percent): ");
		float interest = ioScanner.nextFloat() / 10;
		
		System.out.print("Timespan: ");
		int timespan = ioScanner.nextInt();
		
		ioScanner.close();
		
		System.out.println("Start capital: " + ((int) capital + (int) ((capital - (int) capital + 0.005) * 100) / 100f) + "€");
		
		for(int i = 1; i < timespan + 1; i++) {
			capital *= 1 + interest;
			System.out.println("Year: " + i + " | Capital: " + ((int) capital + (int) ((capital - (int) capital + 0.005) * 100) / 100f) + "€");
		}
		
		
	}
}
