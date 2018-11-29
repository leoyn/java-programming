package chapter9;

public class Task8 {
	public static void main(String[] args) {
		System.out.println(compare("abce", "abcd"));
	}
	
	public static byte compare(String s1, String s2) {	
		int diff = 0;
		
		for(int i = 0; i < s1.length() || i < s2.length(); i++) {
			if(i < s1.length()) diff += s1.charAt(i);
			if(i < s2.length()) diff -= s2.charAt(i);
		}
		
		if(diff > 0) return 1;
		if(diff < 0) return -1;
		
		return 0;
	}
}
