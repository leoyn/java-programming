package chapter16;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(invert("ilike"));
    }

    public static String invert(String string) {
        return invert(string, 0);
    }

    public static String invert(String string, int count) {
        StringBuilder sb = new StringBuilder(string);
        
        sb.insert(count, sb.charAt(sb.length() - 1)).delete(sb.length() - 1, sb.length());
        
        if(++count < sb.length()) return invert(sb.toString(), count);
        else return sb.toString();
    }
}