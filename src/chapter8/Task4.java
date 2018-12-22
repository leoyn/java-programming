package chapter8;

/*
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
*/

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
	
	// Most efficient way i can think of + reading file
	/*
	public static void main(String[] args) throws IOException {
		InputStreamReader streamReader = new InputStreamReader(new FileInputStream(new File("input.txt")), Charset.forName("UTF-8"));
		int currentChar = streamReader.read();
		int lastChar = ' ';
		int length = 0;
		int maxLength = 0;
		
		while(lastChar != -1) {
			if(currentChar == ' ' || currentChar == -1) {
				if(lastChar != ' ') System.out.println(maxLength);
				maxLength = 0;
				length = 0;
			} else {
				if("aeiouäöüAEIOUÄÖÜ".indexOf((char) currentChar) == -1) {
					length++;
				} else length = 0;
				
				if(maxLength < length) maxLength = length;
			}
			
			lastChar = currentChar;
			currentChar = streamReader.read();
		}
		
		streamReader.close();
	}
	*/
}
