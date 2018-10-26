package chapter4;
import java.util.Scanner;

public class Task7 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		int x = ioScanner.nextInt();
		int max = x;
		
		ioScanner.close();
					
		int i = 2;
		while(max > 1 && i <= x) {
					
			boolean isPrime = true;
				
			for(int j = 2; j <= max; j++) {
				if(i != j && i % j == 0) {
					isPrime = false;
					break;
				}
			}
				
			if(max % i == 0 && isPrime) {
				System.out.println(i);
				max = max / i;
				i = 1;
			}
			
			i++;
		}
		// max =< 1 || i > x
		
		if(i > x) System.out.println(x + " kann nicht in Primzahlen zerlegt werden.");
	}
}