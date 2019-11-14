package semester1.chapter9;

public class Task6 {
	public static void main(String[] args) {
		System.out.println(matches("Test---.java", "T*.java"));
	}
	
	public static boolean matches(String s, String pattern) {
		int index = 0;
		int state = 0;
		
		for(int i = 0; i < s.length(); i++) {
			switch(state) {
				case 0:
					if(pattern.charAt(index) == '*') state = 1;
					else if(pattern.charAt(index) != s.charAt(i)) return false;
					else index++;
					break;
				case 1:
					if(i < s.length() - 1) {
						if(s.substring(i + 1).equals(pattern.substring(index + 1))) return true;
					}
					break;
			}
		}
		
		return false;
	}
}
