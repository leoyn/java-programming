package semester1.chapter12.Task2;

import semester1.chapter12.List;
import semester1.chapter12.Element;

public class ReorderedList extends List {
    public ReorderedList reorder() {

        Element last = null;
        Element node = this.head;

        while(node != null) {
            if(node.value < 0 && last != null) {
                last.next = node.next;
                node.next = head;
                head = node;
                node = last.next;
            } else {
                last = node;
                node = node.next;
            }
        }
        
        return this;
    }
}