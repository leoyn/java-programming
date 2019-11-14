package semester1.chapter2;
import java.util.Scanner;

public class Task8 {
	public static void main(String[] args) {
		// Initialize reader
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.println("Polynomrechner y = a * x^3 + b * x^2 + c * x + d");
		
		// Read the vars
		System.out.print("a = ");
		int a = ioScanner.nextInt();
		
		System.out.print("b = ");
		int b = ioScanner.nextInt();
		
		System.out.print("c = ");
		int c = ioScanner.nextInt();
		
		System.out.print("d = ");
		int d = ioScanner.nextInt();
		
		System.out.print("x = ");
		int x = ioScanner.nextInt();
		
		// use long since we use x to the power of i
		long y = calcY(a, b, c, d, x);
		System.out.println("y = " + a + " * " + x + "^3 + " + b + " * " + x + "^2 + " + c + " * " + x + " + " + d);
		System.out.println("y = " + y);
		
		ioScanner.close();
	}
	
	public static long calcY(int a, int b, int c, int d, int x) {
		return x * calcPower(x, 3) + b * calcPower(x, 2) + c * x + d;
	}
	
	
	// Equivalent to x^i or Math.pow(x, i);
	public static int calcPower(int base, int exponent) {
		for(int i = 0; i < exponent; i++) {
			base *= base;
		}
		
		return base;
	}
}
