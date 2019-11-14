package semester1.chapter3;
import java.util.Scanner;

// sort 3 numbers a > b > c

public class Task7 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("a = ");
		int a = ioScanner.nextInt();
		
		System.out.print("b = ");
		int b = ioScanner.nextInt();
		
		System.out.print("c = ");
		int c = ioScanner.nextInt();
		
		ioScanner.close();
		
		int max = c;
		int mid = b;
		int min = a;
		
		if(a > b) {
			if(a > c) {
				// a > b && a > c
				max = a;
				if(c > b) {
					// a > c > b
					mid = c;
					min = b;
				} else {
					// a > b >= c
					min = c;
				}
			} else {
				// b < a =< c
				max = c;
				mid = a;
				min = b;
			}
		} else {
			// a =< b
			if(b > c) {
				// b > a && b > c
				max = b;
				if(c > a) {
					// b > c > a
					mid = c;
				} else {
					// b > a >= c
					min = c;
					mid = a;
				}
			}
			
			// else c >= b > a
			// does not have to be changed since this is the order we initialized the values
		}
		
		System.out.println(max + ", " + mid + ", " + min);
	}
}
