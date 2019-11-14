package semester3.practice.numbers;

public class IntegerOverflow {
	public static void main(String[] args) {
		int a = 100000;
		int b = 100000;
		
		// Integer overflow happens silently
		int result = a * b / 100000;
		System.out.println(result + " ❌ Wrong result");
		
		// Throws exception when integer overflow happens
		System.out.println(Math.multiplyExact(a, b));
		
		// Otherwise use a bigger data type - does not work in this case :(
		long betterResult = a * b / 10000;
		System.out.println(betterResult);
		
		// Why do we have this result?
		// 100.000 * 100.000 = 10.000.000.000
		// However integers can only store values up to 2^31-1
		// 0010 0101 0100 0000 1011 1110 0100 0000 0000
		// Length of number in binary representation is: 66 (first bit that is 1)
		// Since integers can only store values with 32 bits it cuts off the first 1 byte
		//      0101 0100 0000 1011 1110 0100 0000 0000 = 1410065408
		// Now we divide 1.410.065.408 / 100.000 = 14100 (cuts off the decimals numbers)
	}
}
