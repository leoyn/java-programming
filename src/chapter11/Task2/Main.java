package chapter11.Task2;

public class Main {
    public static void main(String[] args) {
        Set set = new Set(127);
        Set set2 = new Set(127);

        System.out.println(set.setBit(4, false).toString());
        System.out.println(set2.setBit(3, false).setBit(7, true).intersect(set).toString());
    }
}