package chapter7;

public class Task16 {
	public static void main(String[] args) {
		System.out.println(poly(4, 1, 3, 2));
	}
	
	public static int poly(int x, int... params) {
		
		int y = 0;
		
		for(int i = 0; i < params.length; i++) {
			y += params[i] * Math.pow(x, params.length - 1 - i);
		}
		
		return y;
	}
}
