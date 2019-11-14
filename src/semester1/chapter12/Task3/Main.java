package semester1.chapter12.Task3;

import semester1.chapter12.Element;

public class Main {
    public static void main(String[] args) {
        InvertedList list = new InvertedList();

        list.push(new Element(-3)).push(new Element(9)).push(new Element(1)).push(new Element(-2));

        list.invert();
    }
}