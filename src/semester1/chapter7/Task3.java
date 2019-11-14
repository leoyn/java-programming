package semester1.chapter7;

public class Task3 {
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{2, 0, 0, 0}, {7, 8, 0, 0}, {6, 5, 6, 0}, {3, 1, 7, 5}};
		
		printArray(getDiagonals(matrix));
	}
	
	public static void printArray(int[] diagonals) {
		for(int i = 0; i < diagonals.length; i++) {
			System.out.print(diagonals[i] + " ");
		}
	}
	
	public static int[] getDiagonals(int[][] matrix) {
		int[] diagonals = new int[matrix.length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < i + 1; j++) {
				diagonals[j] += matrix[i][i-j];
			}
		}
		
		return diagonals;
	}
}
