package chapter7;

public class Task4 {
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{2, 1, 2, 3}, {7, 8, 4, 5}, {6, 5, 6, 6}, {3, 1, 7, 5}};
		
		printMatrix(matrix);
		System.out.println("---------");
		printMatrix(transpose(matrix));
	}
	
	public static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] transpose(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i + 1; j < matrix[i].length; j++) {
				int h = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = h;
			}
		}
		
		return matrix;
	}
}
