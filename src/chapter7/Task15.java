package chapter7;

public class Task15 {
	public static void main(String[] args) {
		System.out.println(max(new int[] {9, 2, 22, 101, -1}));
	}
	
	public static int max(int[] array) {
		int max = 0;
		
		for(int item : array) {
			if(max < item) max = item;
		}
		
		return max;
	}
}
