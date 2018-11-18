package chapter6;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.println("    /\\    ");
		System.out.println(" b /  \\ a ");
		System.out.println("  /____\\  ");
		System.out.println("    c     ");
		System.out.println();
		
		System.out.print("a = ");
		double a = ioScanner.nextDouble();
		
		System.out.print("b = ");
		double b = ioScanner.nextDouble();
		
		System.out.print("c = ");
		double c = ioScanner.nextDouble();
		
		ioScanner.close();
		
		System.out.println("A = " + area(a, b, c));
	}
	
	public static double area(double a, double b, double c) {
		double s = (a + b + c) / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}
}