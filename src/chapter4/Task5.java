package chapter4;
import java.util.Scanner;

public class Task5 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("x = ");
		int x = ioScanner.nextInt();
		
		ioScanner.close();
		
		long bitValue = (long) Math.pow(2, 32);
		for(int i = 32; i > 1; i--) {
			
			if(x / bitValue > 0) {
				System.out.print(i + ", ");
				x -= bitValue;
			}
			
			bitValue = bitValue / 2;
		}
	}
}
