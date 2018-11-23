package chapter7;

public class Task15 {
	public static void main(String[] args) {
		System.out.println(max(new int[] {9, 2, 22, 101, -1}));
	}
	
	public static int max(int[] array) {
		int max = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(max < array[i]) max = array[i];
		}
		
		return max;
	}
}
