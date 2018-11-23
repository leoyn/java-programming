package chapter7;

public class Task14 {
	public static void main(String[] args) {
		System.out.println(sum(new int[][] {{0, 1}, {2, 3}}));
	}
	
	public static int sum(int[][] array) {
		int sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
			}
		}
		
		return sum;
	}
}
