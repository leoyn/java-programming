package chapter16;

public class Task9 {
    public static void main(String[] args) {
        printDigitsRecursively(123);
    }

    public static void printDigitsRecursively(int number) {
        if(number > 0) {
            printDigitsRecursively(number / 10);
            System.out.println(number % 10);
        }
    }
}