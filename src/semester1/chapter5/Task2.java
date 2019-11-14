package semester1.chapter5;
import java.util.Scanner;

// Inverse sin calculation

public class Task2 {
	
	final static float pi = 3.14159f;
	final static int n = 100;
	
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("x = ");
		double x = ioScanner.nextDouble();
		
		ioScanner.close();
		
		if(x <= 1 && x >= -1) {
			
			double sum = x; // f(0) = x
			double previousProduct = x; // since f(0) = x
			double product; // no value assigned, because it will only be read after first value has already been assigned in loop
			
			for(int i = 1; i < n; i++) { // start at 1, because you cannot divide by 0
				product = previousProduct * k(i, x);
				sum += product;
				previousProduct = product;
			}
			
			System.out.println("arcsin(" + x + ") = " + sum * 180/pi + "˚"); // convert radiant to degree
		} else System.out.println("Out of boundary. -1 ≤ x ≤ 1");
	}
	
	public static double k(int i, double x) {
		return ((x * x * (2 * i - 1) * (2 * i - 1)) / (2 * i * (2 * i + 1)));
	}
}
