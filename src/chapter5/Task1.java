package chapter5;
// 🍰 calculator 

public class Task1 {
	
	final static double tolerance = 0.0000025;
	
	public static void main(String[] args) {
		
		double sum = 1;
		double lastSum = 0;
		int i = 1;
		float negator = -1f;
		
		while(Math.abs(sum - lastSum) > tolerance) {
			lastSum = sum;
			sum += (negator / (2 * i + 1));
			negator *= -1; // switch between + and -
			i++;
		}
		
		double pi = 4 * sum;
		// part behind period that has been cut is influenced by the numbers of zeros after the 1
		System.out.println("π ≈ " + (int) (pi * (100000)) / (float) (100000));
	}
}
