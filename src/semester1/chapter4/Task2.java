package semester1.chapter4;
import java.util.Scanner;

// number length of n

public class Task2 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("n = ");
		int n = ioScanner.nextInt();
		
		ioScanner.close();
		
		int length = 0;
		
		while(n != 0) {
			n = n / 10;
			length++;
		}
		
		System.out.println("n hat eine Länge von " + length);
	}
}
