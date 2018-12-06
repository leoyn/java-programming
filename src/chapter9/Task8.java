package chapter9;

public class Task8 {
	public static void main(String[] args) {
		System.out.println(compare("tesa", "tesz"));
	}
	
	public static byte compare(String s1, String s2) {	
		
		for(int i = 0; i < s1.length() || i < s2.length(); i++) {
			int a = 0;
			int b = 0;
			
			if(i < s1.length()) a = s1.charAt(i);
			if(i < s2.length()) b = s2.charAt(i);
			
			if(a > b) return 1;
			if(a < b) return -1;
		}
		
		return 0;
	}
}
