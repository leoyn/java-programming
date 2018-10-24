package chapter2;
import java.util.Scanner;

public class Task9 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		Point point1 = new Point();
		Point point2 = new Point();
		
		// Read x and y position of the two points
		
		System.out.println("Point #1:");
		
		System.out.print("x = ");
		point1.x = ioScanner.nextInt();
		System.out.print("y = ");
		point1.y = ioScanner.nextInt();
		
		System.out.println();
		System.out.println("Point #2:");
		
		System.out.print("x = ");
		point2.x = ioScanner.nextInt();
		System.out.print("y = ");
		point2.y = ioScanner.nextInt();
		
		// Calculate distance in another method
		int distance = calcDistance(point1, point2);
		
		// Output distance
		System.out.println("Distance between points: " + distance);
	}
	
	public static int calcDistance(Point point1, Point point2) {
		int distanceX = point2.x - point1.x;
		int distanceY = point2.y - point1.y;
		
		// Make sure the points are not placed on a vertical or horizontal line
		if(distanceX != 0) {
			if(distanceY != 0) {
				// if not placed on the same do pythagoras equation a^2 + b^2 = c
				return (int) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
			} else {
				// if on the same y-axis get absolute distance. always >= 0
				return Math.abs(distanceX);
			}
		} else {
			// if on the same x-axis get absolute distance. always >= 0
			return Math.abs(distanceY);
		}
	}
}
