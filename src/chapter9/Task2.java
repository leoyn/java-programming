package chapter9;

public class Task2 {
	public static void main(String[] args) {
		System.out.println(mirrorAddress("hermann.maier@students.university.de.edu"));
	}
	
	public static String mirrorAddress(String address) {
		String[] domainParts = address.split("@")[1].split("\\.");
		StringBuilder sb = new StringBuilder();
		
		for(int i = domainParts.length - 1; i >= 0; i--) {
			sb.append(domainParts[i]);
			if(i > 0) sb.append(".");
		}
		
		return sb.toString();
	}
}
