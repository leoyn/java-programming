package chapter9;

public class Task7 {
	public static void main(String[] args) {
		System.out.println(convert(1.5693322E2f, 5));
		System.out.println(convert(1.2f, 5));
	}
	
	public static String valueOf(float x, int precision) {
		StringBuilder sb = new StringBuilder(((int) x ) + ".");
		x -= (int) x;
		
		for(int i = 0; i < precision; i++) {
			x *= 10;
			int remainder = (int) (x % 10);
			sb.append(remainder);
			x -= remainder;
		}
		
		return sb.toString();
	}
	
	public static String convert(float x, int n) {
		StringBuilder sb = new StringBuilder(valueOf(x, n));

		int maxLength = sb.indexOf(".") + n;
		
		for(int i = sb.length(); i < maxLength + 1; i++) sb.append("0");
	
		return sb.toString();
	}
}
