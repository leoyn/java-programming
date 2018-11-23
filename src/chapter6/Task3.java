package chapter6;
import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("x[2] = ");
		long binarySequence = ioScanner.nextLong();
		ioScanner.close();
		
		System.out.println("x[10] = " + getDecimalNumber(binarySequence));
	}
	
	public static int getDecimalNumber(long binarySequence) {
		
		int decimalNumber = 0;
		int index = 0;
		
		while(binarySequence > 0) {
			int r = (int) binarySequence % 10;
			if(r == 1) decimalNumber += Math.pow(2, index);
			else if(r > 1) return -1;
			binarySequence /= 10;
			index++;
		}
		
		return decimalNumber;
	}
}
