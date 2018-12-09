package chapter9;

public class Task4 {
	public static void main(String[] args) {
		String startString = "ABCDEEEEEEEEEEEFFY";
		String encodedString = encode(startString);
		String decodedString = decode(encodedString);

		System.out.println("Does the encoder and decoder work? " + startString.equals(decodedString));
	}
	
	public static String encode(String s) {
		StringBuilder sb = new StringBuilder();
		
		int count = 1;
		
		for(int i = 1; i < s.length() + 1; i++) {
			char lastChar = s.charAt(i - 1);
			char currentChar = 0;
			if(i < s.length()) currentChar = s.charAt(i);
			
			if(currentChar == lastChar) {
				count++;
			} else {
				sb.append(lastChar);
				if(count > 2) sb.append(count);
				else if (count == 2) sb.append(lastChar);
				count = 1;
			}
		}
		
		return sb.toString();
	}
	
	public static String decode(String s) {
		StringBuilder sb = new StringBuilder();
				
		for(int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
		
			if(!Character.isDigit(currentChar)) {
				int count = 1;
			
				if(i < s.length() - 1) {
					int index = i + 1;
					StringBuilder countSb = new StringBuilder();
					while(Character.isDigit(s.charAt(index)) && index < s.length()) {
						countSb.append(s.charAt(index));
						index++;
					}
					if(index > i + 1) count = Integer.parseInt(countSb.toString());
					if(count == 2) throw new Error("Parsing error near '" + currentChar + count +  "' at index " + index);
				}
				
				for(int j = 0; j < count; j++) {
					sb.append(currentChar);
				}
			}
		}
		
		return sb.toString();
	}
}
