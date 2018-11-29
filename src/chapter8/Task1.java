package chapter8;

import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("x[10] = ");
		printHex(ioScanner.nextInt());
		ioScanner.close();
	}
	
	public static void printHex(int number) {
		
		int size = log16(number);
		
		char[] digits = new char[size];
		
		for(int i = size - 1; i > -1; i--) {
			int remainder = number % 16;
			int offset = '0';
			if(remainder > 9) offset = 'a' - 10;
			digits[i] = (char) (offset + remainder);
			number /= 16;
		}
		
		System.out.print("x[16] = 0x");
		
		for(char digit: digits) {
			System.out.print(digit);
		}
		
		System.out.println();
	}
	
	public static int log16(int number) {
		int log = 0;
		
		while(number / Math.pow(16, log) >= 1) {
			log++;
		}
		
		return log;
	}
}