package semester1.chapter3;
import java.util.Scanner;

// triangle checker

public class Task2 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("a = ");
		int a = ioScanner.nextInt();
		
		System.out.print("b = ");
		int b = ioScanner.nextInt();
		
		System.out.print("c = ");
		int c = ioScanner.nextInt();
		
		ioScanner.close();
		
		boolean isValidTriangle = (a + b > c) && (a + c > b) && (b + c > a);
		boolean isEqTriangle = (a == b && a == c);
		boolean hasRightAngle = (a * a + b * b == c * c || c * c + b * b == a * a || a * a + c * c == b * b);
		
		String properties = "UNGÜLTIGES";
		
		if(isValidTriangle) {
			properties = "gültiges";
			
			if(isEqTriangle) properties += " gleichschenkliges";
			else if(hasRightAngle) properties += " rechtwinkliges";
		}
		
		System.out.println("Die Seiten ergeben ein " + properties + " Dreieck.");
	}
}
