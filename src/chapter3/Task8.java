package chapter3;
import java.util.Scanner;

// Date validation

public class Task8 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("Tag:");
		int day = ioScanner.nextInt();
		
		System.out.print("Monat:");
		int month = ioScanner.nextInt();
		
		System.out.print("Jahr:");
		int year = ioScanner.nextInt();
		
		ioScanner.close();
		
		boolean isValidDate = false;
		
		if(year > 0 && day > 0 && month > 0 && month < 13 && day < 32) {
			switch(month) {
				case 2:
					// !(year % 100 == 0 && year % 400 != 0) --> demorgan regel
					boolean isLeapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
					
					if(day == 28 && isLeapYear) isValidDate = true;
					else if(day < 28) isValidDate = true;
					
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if(day < 31) isValidDate = true;
					break;
				default:
					isValidDate = true;
					break;
			}
		}
		
		if(isValidDate) System.out.println("Datum ist valid");
		else System.out.println("Datum ist INVALID");
	}
}
