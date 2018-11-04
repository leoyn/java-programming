package chapter3;
import java.util.Scanner;

// day of week calculator

public class Task9 {
		
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("Tag:");
		int day = ioScanner.nextInt() - 1; // index ranges from 0 to 6, because x % 7 will never have a 7
		
		System.out.print("Monat:");
		int month = ioScanner.nextInt();
		
		System.out.print("Jahr:");
		int year = ioScanner.nextInt();
		
		System.out.print("Erster Wochentag des Jahres:");
		int firstDayOfWeek = ioScanner.nextInt();
		System.out.println();
		
		ioScanner.close();
		
		if(firstDayOfWeek < 7 && firstDayOfWeek > -1) {
		
			int days = firstDayOfWeek + day - 1; // we don't want to add any days for the first day of month 
			if(month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) days++;
				
			switch(month) {
				case 2:
					days += 31;
					break;
				case 3:
					days += 59;
					break;
				case 4:
					days += 90;
					break;
				case 5:
					days += 120;
					break;
				case 6:
					days += 151;
					break;
				case 7:
					days += 181;
					break;
				case 8:
					days += 212;
					break;
				case 9:
					days += 243;
					break;
				case 10:
					days += 273;
					break;
				case 11:
					days += 304;
					break;
				case 12:
					days += 334;
					break;
			}
			String dayOfWeekString = "";
			days = days % 7;
			
			switch(days) {
				case 0:
					dayOfWeekString = "Montag";
					break;
				case 1:
					dayOfWeekString = "Dienstag";
					break;
				case 2:
					dayOfWeekString = "Mittwoch";
					break;
				case 3:
					dayOfWeekString = "Donnerstag";
					break;
				case 4:
					dayOfWeekString = "Freitag";
					break;
				case 5:
					dayOfWeekString = "Samstag";
					break;
				case 6:
					dayOfWeekString = "Sonntag";
					break;
			}
			
			System.out.println("Der Wochentag am " + day + "." + month + "." + year + " ist ein " + dayOfWeekString);
		}
	}
}
