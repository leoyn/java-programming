package semester1.chapter2;
import java.util.Scanner;

public class Task10 {
	
	final static String CURRENCY = "€";
	
	final static int CABLE_DRUM_LENGTH = 500;
	final static int CABLE_PRICE_PER_METER = 2;
	final static int CABLE_PRICE_PER_METER_FOR_NOT_FULLY_USED_CABLE_DRUMS = 3;
	final static int WAGE_PER_HOUR = 50;
	final static int OVERTIME_WAGE_PER_HOUR = 100;
	final static int OVERTIME_THRESHOLD = 40;
	
	public static void main(String[] args) {
		
		Scanner ioScanner = new Scanner(System.in);
		
		// Read meters of cable
		System.out.print("Meter: ");
		int cableLength = ioScanner.nextInt();
		
		
		// Read amount of working hours
		System.out.print("Stunden: ");
		int workingHours = ioScanner.nextInt();
		
		// calculate not used meters
		int notUsedMeters = cableLength % CABLE_DRUM_LENGTH;
		
		// calculate cable price
		int cablePrice = (cableLength - notUsedMeters) * CABLE_PRICE_PER_METER + notUsedMeters * CABLE_PRICE_PER_METER_FOR_NOT_FULLY_USED_CABLE_DRUMS;
		
		// initialize wage since its used in an if/else statement
		int wage;
		int overtimeWage = 0;
		if(workingHours > OVERTIME_THRESHOLD) {
			wage = WAGE_PER_HOUR * OVERTIME_THRESHOLD;
			overtimeWage = (workingHours - OVERTIME_THRESHOLD) * OVERTIME_WAGE_PER_HOUR;
		} else wage = workingHours * WAGE_PER_HOUR;

		// total wage
		int total = (wage + overtimeWage + cablePrice);
		
		// Print 
		System.out.println();
		System.out.println("––––––– RECHNUNG ––––––––");
		System.out.println("Kabelpreis........" + cablePrice + CURRENCY);
		System.out.println("Stundenlohn......." + wage + CURRENCY);
		System.out.println("Überstundenlohn..." + overtimeWage + CURRENCY);
		System.out.println("=========================");
		System.out.println("Netto............." + total + CURRENCY);
		System.out.println("Brutto............" + (int) ((total * 0.81 + 0.005) * 100) / 100f + CURRENCY);
		
		ioScanner.close();
	}
}
