package chapter3;
import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("x = ");
		int x = ioScanner.nextInt();
		
		System.out.print("y = ");
		int y = ioScanner.nextInt();
		
		System.out.print("z = ");
		int z = ioScanner.nextInt();
		
		ioScanner.close();
				
		boolean areNotAllTheSameValue = (x - y != z - y);
		boolean areAllDifferentValues = (x != y) && (x != z) && (x != y);
		boolean twoHaveTheSameValue = (x == y) || (x == z) || (y == z);
		
		if(areNotAllTheSameValue) System.out.println("x, y, z haben nicht alle die gleichen Werte.");
		if(areAllDifferentValues) System.out.println("x, y, z haben alle verschiedene Werte.");
		if(twoHaveTheSameValue) System.out.println("Mindestens zwei von x, y, z haben die gleichen Werte.");
	}
}
