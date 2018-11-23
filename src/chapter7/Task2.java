package chapter7;

import java.util.Scanner;

public class Task2 {
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
		boolean isSymetrical = isSymetrical(matrix);	
		if(isSymetrical) {
			removeBottomTriangleMatrix(matrix);
		}
		
		printMatrix(matrix, isSymetrical);
		
	}
	
	public static void printMatrix(int[][] matrix, boolean isSymetrical) {
		for(int i = 0; i < matrix.length; i++) {
			if(isSymetrical) for(int j = 0; j < i; j++) System.out.print("  ");
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean isSymetrical(int[][] matrix) {
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i + 1; j < matrix.length; j++) {
				if(matrix[i][j] != matrix[j][i]) return false;
			}
		}
		
		return true;
	}
	
	public static void removeBottomTriangleMatrix(int[][] matrix) {
		
		for(int i = 0; i < matrix.length; i++) {
			int[] row = new int[matrix.length - i];
			
			int relativeIndex = 0;
			for(int j = i; j < matrix[i].length; j++, relativeIndex++) {
				row[relativeIndex] = matrix[i][j];
			}
			
			matrix[i] = row;
		}
	}
}
