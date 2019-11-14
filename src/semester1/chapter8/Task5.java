package semester1.chapter8;

public class Task5 {
	public static void main(String[] args) {
		printHistogram(getHistogram('a', 'b', 'a'));
	}
	
	public static void printHistogram(int[][] histogram) {
		for(int i = 0; i < histogram[0].length; i++) {
			char letter = (char) histogram[0][i];
			
			if(letter > 0) {
				System.out.print(letter + " | ");
				
				for(int j = 0; j < histogram[1][i]; j++) {
					System.out.print("*");
				}
				
				System.out.println();
			}
		}
	}
	
	public static int indexOf(int[] array, int value) {
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) return i;
		}
		
		return -1;
	}
	
	public static int[][] getHistogram(char... letters) {
		int[][] histogram = new int[2][letters.length];
		int pointer = 0;
		
		for(char letter: letters) {
			int index = indexOf(histogram[0], letter);
			
			if(index > -1) {
				histogram[1][index]++;
			} else {
				histogram[0][pointer] = letter;
				histogram[1][pointer] = 1;
				pointer++;
			}
		}
		
		return histogram;
	}
}
