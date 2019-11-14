package semester1.chapter7;

public class Task16 {
	public static void main(String[] args) {
		System.out.println(poly(2.5, 3, -1.5, 0, 4.2));
	}
	
	public static double poly(double x, double... params) {
		
		double y = 0;
		
		for(int i = 0; i < params.length; i++) {
			y += params[i] * Math.pow(x, params.length - 1 - i);
		}
		
		return y;
	}
}
