package chapter11.Task6;

public class Main {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary();

        dic.add("Yoshi", "Kackvieh");
        dic.add("Yoshi2", "Kackvieh2");

        System.out.println(dic.get("Yoshi") + " " + dic.get("Yoshi3"));
    }
}