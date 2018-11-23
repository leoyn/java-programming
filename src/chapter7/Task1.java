package chapter7;

public class Task1 {
	public static void main(String[] args) {
		int[] array = new int[] {0,1,2,3,4,5};
				
		printArray(invert(array));
	}
	
	public static int[] invert(int[] array) {
		
		for(int i = 0; i < array.length/2; i++) {
			int h = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = h;
		}
		
		return array;
	}
	
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(i != 0) System.out.print(",");
			System.out.print(array[i]);
		}
		
		System.out.println();
	}
}
