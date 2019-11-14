package semester1.chapter16;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(iterative(8));
        System.out.println(recursive(8));
    }

    public static int recursive(int n) {
        if(n <= 1) return 1;
        return recursive(n - 2) + recursive(n - 1);
    }

    public static int iterative(int n) {
        int a = 1;
        int b = 0;

        for(int i = 0; i < n; i++) {
            int term = a + b;
            b = a;
            a = term;
        }

        return a;
    }
}