package chapter12.Task3;

import chapter12.List;
import chapter12.Element;

public class InvertedList extends List {
    public InvertedList invert() {

        Element prev = null;
        Element current = head;
        Element next = head.next;
        current.next = prev;

        while(next != null) {
            prev = current;
            current = next;
            next = next.next;
            current.next = prev;
        }

        head = current;

        return this;
    }
}