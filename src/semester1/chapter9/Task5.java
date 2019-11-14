package semester1.chapter9;

public class Task5 {
	public static void main(String[] args) {
		System.out.println(isAnagram("Maus", "saaum"));
	}
	
	public static boolean isAnagram(String word1, String word2) {
		
		StringBuilder sbWord1 = new StringBuilder(word1.toLowerCase());
		StringBuilder sbWord2 = new StringBuilder(word2.toLowerCase());
		
		
		while(sbWord1.length() > 0 && sbWord2.length() > 0) {
			
			String currentChar = sbWord1.substring(0, 1);
			int indexOfWord2 = sbWord2.indexOf(currentChar);
								
			if(indexOfWord2 < 0) return false;
			
			sbWord1 = sbWord1.delete(0, 1);
			sbWord2 = sbWord2.delete(indexOfWord2, indexOfWord2 + 1);
		}
		
		if(sbWord2.length() != sbWord1.length()) return false;
		
		return true;
	}
}
