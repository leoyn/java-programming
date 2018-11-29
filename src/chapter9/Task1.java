package chapter9;

public class Task1 {
	public static void main(String[] args) {
		System.out.println(hash("Anton"));
	}
	
	public static int hash(String s) {
		int hash = 0;
		
		for(int i = 0; i < s.length(); i++) {
			hash = (2 * hash) ^ s.charAt(i);
		}
		
		return hash;
	}
}
