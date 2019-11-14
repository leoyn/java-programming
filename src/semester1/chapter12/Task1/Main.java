package semester1.chapter12.Task1;

import semester1.chapter12.Element;

public class Main {
    public static void main(String[] args) {
        ListMax list = new ListMax();

        list.push(new Element(3)).push(new Element(7)).push(new Element(9)).push(new Element(-3));

        System.out.println("Maximum: " + list.getMaximum());
    }
}