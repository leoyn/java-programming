package semester1.chapter7;

public class Task11 {
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
		boolean isSorted = false;
		
		while(!isSorted) {
			isSorted = true;
			
			for(int i = 1; i < array.length; i++) {
				if(array[i] < array[i - 1]) {
					isSorted = false;
					int h = array[i - 1];
					array[i - 1] = array[i];
					array[i] = h;
				}
			}
		}
	}
}
