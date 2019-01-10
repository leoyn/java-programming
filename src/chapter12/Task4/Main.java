package chapter12.Task4;

public class Main {
    public static void main(String[] args) {
        List list = new List();

        list.push(new Element(3)).push(new Element(4)).push(new Element(2));

        list.remove(2);
    }
}