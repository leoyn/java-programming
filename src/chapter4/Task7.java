package chapter4;
import java.util.Scanner;

public class Task7 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		int x = ioScanner.nextInt();
		
		ioScanner.close();
					
		int i = 2;
		while(x > 1) {
					
			boolean isPrime = true;
				
			for(int j = 2; j <= x; j++) {
				if(i != j && i % j == 0) {
					isPrime = false;
					break;
				}
			}
				
			if(x % i == 0 && isPrime) {
				System.out.println(i);
				x = x / i;
				i = 1;
			}
			
			i++;
		}
	}
}