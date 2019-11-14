package semester1.chapter7;

public class Task9 {
	public static void main(String[] args) {
		double[][] matrix = new double[][] {{1, 0, 3, -1}, {0, 0, 4, -2}, {0, 4, 5, -3}};
		
		normalizeMatrix(matrix);
				
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i + 1; j < matrix.length; j++) {
				if(matrix[j][i] != 0) {
					normalizeRow(matrix, i);
					multiplyRow(matrix, i, matrix[j][i]);
					subtractRow(matrix, i, j);
				}
			}
			normalizeRow(matrix, i);
		}
		
		makeResultPretty(matrix);
		
		printMatrix(matrix);
	}
	
	public static void printMatrix(double[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void normalizeMatrix(double[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length && matrix[i][i] == 0; j++) {
				if(matrix[j][i] != 0) {
					double[] row = matrix[i];
					matrix[i] = matrix[j];
					matrix[j] = row;
				}
			}
		}
	}
	
	public static void makeResultPretty(double[][] matrix) {
		// Apply some make-up
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i + 1; j < matrix.length ; j++) {
				if(matrix[i][j] != 0) {
					multiplyRow(matrix, j, matrix[i][j]);
					subtractRow(matrix, j, i);
					normalizeRow(matrix, j);
				}
				matrix[i][j] = Math.round(matrix[i][j]);
			}
			matrix[i][matrix.length - 1] = Math.round(matrix[i][matrix.length - 1]);
		}
	}
	
	public static void normalizeRow(double[][] matrix, int row) {
		if(matrix[row][row] < 0) multiplyRow(matrix, row, -1);
		if(matrix[row][row] > 0) multiplyRow(matrix, row, 1 / matrix[row][row]);
	}
	
	public static void subtractRow(double[][] matrix, int subRow, int affectedRow) {
		for(int i = 0; i < matrix[subRow].length; i++) {
			matrix[affectedRow][i] -= matrix[subRow][i];
		}
	}
	
	public static void multiplyRow(double[][] matrix, int row, double m) {
		for(int i = 0; i < matrix[row].length; i++) {
			matrix[row][i] *= m;
		}
	}
}
