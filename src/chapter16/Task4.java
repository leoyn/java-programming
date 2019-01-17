package chapter16;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(iterative(20, 3));
        System.out.println(recursive(20, 3));
    }

    public static double recursive(int n, int k) {
        if(k == 0) return 1;
        if(k > n) return 0;
        return recursive(n - 1, k - 1) + recursive(n - 1, k);
    }

    private static long factorial(long number) {
        long sum = number--;
        while(number > 1) sum *= number--;
        return sum;
    }

    public static double iterative(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }
}