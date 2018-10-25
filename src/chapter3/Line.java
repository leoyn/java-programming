package chapter3;

public class Line {
	Point start = new Point();
	Point end = new Point();
	
	public int getType() {
		if(start.y == end.y) {
			return 1; // horizontal
		}
		if(start.x == end.x) {
			return 2; // vertical;
		} else {
			return 0; // not vertical nor horizontal
		}
	}
}
