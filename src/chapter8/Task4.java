package chapter8;

public class Task4 {
	public static void main(String[] args) {
		char[][] text = new char[][] {{'H', 'e', 'l', 'l', 'o'}, {'W', 'o', 'r', 'l', 'd'}, {'Ä', 'p', 'f', 'e', 'l'}};
		
		for(char[] word : text) {
			printWord(word);
			System.out.print(" :" + getConsonantStreak(word));
			System.out.println();
		}
	}
	
	public static void printWord(char[] word) {
		for(char letter : word) {
			System.out.print(letter);
		}
	}
	
	public static int getConsonantStreak(char[] word) {
		int max = 0;
		int count = 0;
		
		for(char letter : word) {
			
			if(Character.isLetter(letter)) {
				char normalizedLetter = Character.toLowerCase(letter);
				
				switch(normalizedLetter) {
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
					case 'ä':
					case 'ö':
					case 'ü':
						count = 0;
						break;
					default:
						count++;
				}
			}
			
			if(max < count) max = count;
		}
		
		return max;
	}
}
