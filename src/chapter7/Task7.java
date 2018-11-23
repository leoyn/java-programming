package chapter7;

import java.util.Scanner;

public class Task7 {
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		int n = ioScanner.nextInt();
		
		ioScanner.close();
		
		byte[][] matrix = new byte[n][n];
		byte[] stream = new byte[] {1, 3, 2, 3, 4, 5, 6, 6};
		
		if(transform(stream, matrix)) {
			printStream(getStream(matrix));
		}
	}
	
	public static void printStream(byte[] stream) {
		for(int i = 0; i < stream.length; i++) {
			System.out.print(stream[i] + " ");
		}
	}
	
	public static byte[] getStream(byte[][] matrix) {
		byte[] stream = new byte[matrix.length * matrix.length];
		
		for(int i = 0; i < stream.length; i++) {
			stream[i] = matrix[i % 3][i / 3];
		}
		
		return stream;
	}
	
	public static boolean transform(byte[] stream, byte[][] matrix) {
		if(matrix.length * matrix.length < stream.length) return false;
			
		for(int i = 0; i < stream.length; i++) {
			matrix[i / matrix.length][i % matrix.length] = stream[i];
		}
		
		return true;
	}
}
