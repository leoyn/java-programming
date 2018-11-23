package chapter7;

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
		
		for(int i = 0; i < matrix.length; i++) {
			int rowSum = 0;
			int lastColumn = 0;
			
			for(int j = 0; j < matrix[i].length; j++) {
				rowSum += matrix[i][j];
				columnSum[j] += matrix[i][j];
				
				if(i == j) diagonalSum[0] += matrix[j][j];
				else if(matrix.length - 1 - j == matrix.length - 1 - i) diagonalSum[1] += matrix[i][j];
				
				if(i == matrix.length - 1) {
					if(j != 0 && lastColumn != columnSum[j]) return false;
						
					lastColumn = columnSum[j];
				}
			}
			
			if(i != 0 && lastRowSum != rowSum) return false;
			
			lastRowSum = rowSum;
		}
		
		if(diagonalSum[0] != diagonalSum[0]) return false;
		
		return true;
	}
}
