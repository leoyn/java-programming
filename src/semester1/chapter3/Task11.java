package semester1.chapter3;
import java.util.Scanner;

// Schnittpunktberechner

public class Task11 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		Line line1 = new Line();
				
		line1.start.x = ioScanner.nextInt();
		line1.start.y = ioScanner.nextInt();
				
		line1.end.x = ioScanner.nextInt();
		line1.end.y = ioScanner.nextInt();
		
		
		Line line2 = new Line();
				
		line2.start.x = ioScanner.nextInt();
		line2.start.y = ioScanner.nextInt();
				
		line2.end.x = ioScanner.nextInt();
		line2.end.y = ioScanner.nextInt();
		
		ioScanner.close();
		
		if(line1.getType() != line2.getType() && line1.getType() != 0 && line2.getType() != 0) {
			if(line1.getType() == 1) {
				if(line1.start.x > line1.end.x) {
					Point tmp = line1.start;
					line1.start = line1.end;
					line1.end = tmp;
				}
				
				if(line2.start.y > line2.end.y) {
					Point tmp = line2.start;
					line2.start = line2.end;
					line2.end = tmp;
				}
				
				if(line1.start.x <= line2.start.x && line1.end.x >= line2.end.x && line2.start.y <= line1.start.y && line2.end.y >= line1.end.y) System.out.println("Beide Linien schneiden sich");
				else System.out.println("Beide Linien schneiden sich NICHT!"); 
			} else {
				if(line2.start.x > line2.end.x) {
					Point tmp = line2.start;
					line2.start = line2.end;
					line2.end = tmp;
				}
				
				if(line1.start.y > line1.end.y) {
					Point tmp = line1.start;
					line1.start = line1.end;
					line1.end = tmp;
				}
				
				
				if(line2.start.x <= line1.start.x && line2.end.x >= line1.end.x && line1.start.y <= line2.start.y && line1.end.y >= line2.end.y) System.out.println("Beide Linien schneiden sich"); 
				else System.out.println("Beide Linien schneiden sich NICHT!"); 
			}
		} else System.out.println("Schnittpunkt kann nicht berechnet werden, da nicht beide Linien horizontal oder vertikal verlaufen."); 
	}
}
