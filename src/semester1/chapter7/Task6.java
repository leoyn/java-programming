package semester1.chapter7;

import java.util.Scanner;

public class Task6 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		System.out.print("Size of matrix: ");
		int n = ioScanner.nextInt();
		
		int[][] matrix = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = ioScanner.nextInt();
			}
		}
		
		ioScanner.close();
		
		System.out.println("Is it a magical matrix? " + isMagical(matrix));
	}
	
	public static boolean isMagical(int[][] matrix) {
		int[] diagonalSum = new int[2];
		int[] columnSum = new int[matrix.length];
		int lastRowSum = 0;
		int lastColumnSum = 0;
		
		for(int i = 0; i < matrix.length; i++) {
			int rowSum = 0;
			lastColumnSum = 0;
			
			for(int j = 0; j < matrix[i].length; j++) {
				rowSum += matrix[i][j];
				columnSum[j] += matrix[i][j];
				
				if(i == j) diagonalSum[0] += matrix[j][j];
				if(matrix.length - 1 - j == matrix.length - 1 - i) diagonalSum[1] += matrix[i][j];
				
				if(i == matrix.length - 1) {
					if(j != 0 && lastColumnSum != columnSum[j]) return false;
						
					lastColumnSum = columnSum[j];
				}
			}
			
			if(i != 0 && lastRowSum != rowSum) return false;
			
			lastRowSum = rowSum;
		}
		
		if(lastColumnSum != lastRowSum || diagonalSum[0] != lastRowSum || diagonalSum[0] != diagonalSum[1]) return false;
		
		return true;
	}
}
