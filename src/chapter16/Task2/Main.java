package chapter16.Task2;

public class Main {
    public static void main(String[] args) {
        List list = new List();

        list.push(new Element(3)).push(new Element(2)).push(new Element(5)).push(new Element(6));

        list.remove(5);

        Element result = list.get(5);

        System.out.println(result != null ? result.value : "Not found");
    }
}