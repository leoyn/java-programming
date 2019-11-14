package semester1.chapter7;

public class Task10 {
	public static void main(String[] args) {
		int[] array = new int[] {0, 1, 5, 3, 2, 4};
		
		sort(array);
		printArray(array);
	}
	
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void sort(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			
			int min = array[i];
			
			for(int j = i + 1; j < array.length; j++) {
				if(min > array[j]) {
					array[i] = array[j];
					array[j] = min;
					min = array[i];
				}
			}
		}
	}
}
