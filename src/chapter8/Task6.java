package chapter8;

public class Task6 {
	public static void main(String[] args) {
		printLetters(rotate(1, 'a', 'Z'));
	}
	
	public static void printLetters(char[] letters) {
		for(char letter: letters) {
			System.out.print(letter);
		}
		
	}
	
	public static char[] rotate(int offset, char... letters) {
		for(int i = 0; i < letters.length; i++) {
			if(Character.isLetter(letters[i])) {
				
				char letter = letters[i];
				int base = 'a';
				if(letter >= 'A' && letter <= 'Z') base = 'A';
				
				letters[i] = (char) ((letter - base + offset) % 26 + base);
			}
		}
		
		return letters;
	}
}
