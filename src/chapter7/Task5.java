package chapter7;

import java.util.Scanner;

public class Task5 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("Length of sequence: ");
		int n = ioScanner.nextInt();
		
		int[] numbers = new int[n];
		
		for(int i = 0; i < n; i++) {
			numbers[i] = ioScanner.nextInt();
		}
		
		ioScanner.close();
		
		System.out.println("Highest sum of part sequence is " + getMaxValue(numbers));
		
	}
	
	public static int getMaxValue(int[] numbers) {
		int max = -1;
		
		for(int i = 0; i < numbers.length; i++) {
			int sum = numbers[i];
			
			for(int j = i + 1; j < numbers.length; j++) {
				sum += numbers[j];
				if(max < sum) max = sum;
			}
		}
		
		return max;
	}
}
