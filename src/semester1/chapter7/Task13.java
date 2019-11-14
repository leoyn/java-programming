package semester1.chapter7;

public class Task13 {
	public static void main(String[] args) {
		System.out.println(negativeValues(new int[] {-1, 3, -2}));
	}
	
	public static int negativeValues(int[] array) {
		int count = 0;
		
		for(int number : array) {
			if(number < 0) count++;
		}
		
		return count;
	}
}
