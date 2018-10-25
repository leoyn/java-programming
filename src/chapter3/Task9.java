package chapter3;
import java.util.Scanner;

// day of week calculator

public class Task9 {
	
	final static int CURRENT_YEAR = 2018;
	
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("Tag:");
		int day = ioScanner.nextInt();
		System.out.println();
		
		System.out.print("Monat:");
		int month = ioScanner.nextInt();
		System.out.println();
		
		System.out.print("Jahr:");
		int year = ioScanner.nextInt();
		System.out.println();
		
		System.out.print("Erster Wochentag des Jahres:");
		int firstDayOfWeek = ioScanner.nextInt();
		System.out.println();
		
		assert (firstDayOfWeek < 8 && firstDayOfWeek > 0) : "Der Wochentag liegt außerhalb des möglichen Bereichs";
		
		int days = 0;
		boolean isLeapYear = false;
		
		for(int i = 0; i < Math.abs(CURRENT_YEAR - year); i++) {
			if((year + i) % 4 == 0 && ((year + i) % 100 != 0 || (year + i) % 400 == 0)) {
				days++;
			}
			days += 365;
		}
		
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) isLeapYear = true;
		
		int monthDays = 0;
		
		switch(month) {
			case 1:
				// DO NOT ADD ANY DAYS!
				break;
			case 2:
				monthDays += 31;
				break;
			case 3:
				monthDays += 59;
				break;
			case 4:
				monthDays += 90;
				break;
			case 5:
				monthDays += 120;
				break;
			case 6:
				monthDays += 151;
				break;
			case 7:
				monthDays += 181;
				break;
			case 8:
				monthDays += 212;
				break;
			case 9:
				monthDays += 243;
				break;
			case 10:
				monthDays += 273;
				break;
			case 11:
				monthDays += 304;
				break;
			case 12:
				monthDays += 334;
				break;
		}
		
		if(CURRENT_YEAR > year) days -= monthDays + day;
		else days += monthDays + day - 1;
				
		if(month < 2 && CURRENT_YEAR > year && isLeapYear) days++;
		
		int dayOfWeek = 7 - (days % 7 + firstDayOfWeek) % 7;
		String dayOfWeekString = "";
		
		switch(dayOfWeek) {
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
		
		System.out.println("Der 1. Januar liegt " + days + " Tage davon entfernt.");
		System.out.println("Der Tag am " + day + "." + month + "." + year + " ist ein " + dayOfWeekString);
		
		ioScanner.close();
	}
}
