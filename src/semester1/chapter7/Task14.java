package semester1.chapter7;

public class Task14 {
	public static void main(String[] args) {
		System.out.println(sum(new int[][] {{0, 1}, {2, 3}}));
	}
	
	public static int sum(int[][] array) {
		int sum = 0;
		
		for(int[] row : array) {
			for(int cell : row) {
				sum += cell;
			}
		}
		
		return sum;
	}
}
