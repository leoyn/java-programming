package chapter2;
import java.util.Scanner;

public class Task7 {
	public static void main(String[] args) {
		// Initialize reader
		Scanner ioScanner = new Scanner(System.in);
		
		// Prompt for user input
		System.out.print("Please insert your time in seconds: ");
		
		// Reads time from console
		int timeInSeconds = ioScanner.nextInt();
		
		// Initialize Time interface
		Time parsedTime = parseTime(timeInSeconds);
		
		// Output parsed time to console
		System.out.println(parsedTime.hours + ":" + parsedTime.minutes + ":" + parsedTime.seconds);
		
		ioScanner.close();
	}
	
	public static Time parseTime(int timeInSeconds) {
		// Initiate and create time Object
		Time time = new Time();
		
		time.hours = timeInSeconds / 3600;		
		time.minutes = timeInSeconds % 3600 / 60;
		time.seconds = timeInSeconds % 60;
				
		// Return time to main method
		return time;
	}
}
