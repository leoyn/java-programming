package semester1.chapter4;
import java.util.Scanner;

public class Task5 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("x = ");
		int x = ioScanner.nextInt();
		ioScanner.close();
		
		// example for 10
		for(int i = 0; x > 0; i++) {
			
			if(x % 2 == 1) { // 10 / 2 = 5 R0; 5 / 2 = 2 R1; 2 / 2 = 1 R0; 1 / 2 = 0 R1;
				System.out.print(i + ", "); // x % 2 == 0; print 1; x % 2 == 0; print 3;
			}
			
			x = x / 2; // 10 / 2 = 5; 5 / 2 = 2; 2 / 2 = 1; 1 / 2 = 0;
		}
	}
}
