package chapter8;

public class Task2 {
	public static void main(String[] args) {
		System.out.println(generateVerificationByte('a', 'b', 'c'));
	}
	
	public static byte generateVerificationByte(char... text) {
		byte verificationByte = 0;
		
		for(char letter : text) {
			verificationByte = (byte) (verificationByte ^ letter);
		}
		
		return verificationByte;
	}
}
