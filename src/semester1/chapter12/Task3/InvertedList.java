package semester1.chapter12.Task3;

import semester1.chapter12.List;
import semester1.chapter12.Element;

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