package semester1.chapter9;

public class Task9 {
	public static void main(String[] args) {
		print("$9 $ $0 - $1 = $2", 55, 44, 11);
	}
	
	public static void print(String s, int... values) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == '$') {
				int index = i + 1;
				while(index < s.length() && Character.isDigit(s.charAt(index))) index++;
				
				if(index > i + 1) {
					int count = Integer.parseInt(s.substring(i + 1, index));
										
					if(count < values.length) sb.append(values[count]);
					else sb.append("$");
				} else sb.append("$");
			} else sb.append(s.charAt(i));
		}
		
		System.out.println(sb.toString());
	}
}
