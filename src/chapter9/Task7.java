package chapter9;

public class Task7 {
	public static void main(String[] args) {
		System.out.println(convert(1.569332227E2f, 5));
		System.out.println(convert(1.5693E2f, 5));
	}
	
	public static String convert(float x, int n) {
		StringBuilder sb = new StringBuilder(String.valueOf(x));
		int length = sb.indexOf(".") + n + 1;
		
		for(int i = sb.length(); i < length; i++) sb.append("0");
	
		return sb.substring(0, length);
	}
}
