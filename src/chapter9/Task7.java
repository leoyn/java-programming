package chapter9;

public class Task7 {
	public static void main(String[] args) {
		System.out.println(convert(1.569332227E2f, 5));
		System.out.println(convert(1.2f, 5));
	}
	
	public static String valueOf(float x, int precision) {
		StringBuilder sb = new StringBuilder();
		int integer = (int) x;
		x -= integer;
		
		while(integer > 0) {
			sb.insert(0, integer % 10);
			integer /= 10;
		}
		
		sb.append(".");
		
		for(int i = 0; i < precision; i++) {
			x *= 10;
			sb.insert(sb.length(), (int) (x % 10));
		}
		
		return sb.toString();
	}
	
	public static String convert(float x, int n) {
		StringBuilder sb = new StringBuilder(valueOf(x, n));

		int length = sb.indexOf(".") + n + 1;
		
		for(int i = sb.length(); i < length; i++) sb.append("0");
	
		return sb.substring(0, length);
	}
}
