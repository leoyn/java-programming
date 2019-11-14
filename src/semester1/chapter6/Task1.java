package semester1.chapter6;
import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("x = ");
		float x = ioScanner.nextFloat();
		ioScanner.close();
		
		System.out.println("∛" + x + " = " + root3(x));
	}
	
	public static float root3(float x) {
		
		float y = x / 3;
		float lastY = 0;
		
		while(Math.abs(y - lastY) >= 0.00001) {
			lastY = y;
			y = (2 * y + (x / (y * y))) / 3;
		}
		
		return y;
	}
}
