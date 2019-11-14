package semester1.chapter12.Task2;

import semester1.chapter12.Element;

public class Main {
    public static void main(String[] args) {
        ReorderedList list = new ReorderedList();
        
        list.push(new Element(-3)).push(new Element(9)).push(new Element(1)).push(new Element(-2));
        list.reorder();
    }
}