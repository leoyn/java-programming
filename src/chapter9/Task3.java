package chapter9;

public class Task3 {
	public static void main(String[] args) {
		printArray(reformatNames("Alex Richard Max Mustermann", "Linus Neumann"));
	}
	
	public static void printArray(String[] array) {
		for(String name: array) {
			System.out.println(name);
		}
	}
	
	public static String[] reformatNames(String... array) {
		
		for(int i = 0; i < array.length; i++) {
			String[] nameParts = array[i].split(" ");
			StringBuilder sb = new StringBuilder();
			
			sb.append(nameParts[nameParts.length - 1] + ", " + nameParts[0]);
			
			if(nameParts.length > 2) {
				for(int j = 1; j < nameParts.length - 1; j++) {
					sb.append(" " + nameParts[j].charAt(0) + ".");
				}
			}
			
			array[i] = sb.toString();
			
		}
		
		return array;
	}
}
