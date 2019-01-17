package chapter12.Task2;

import chapter12.List;
import chapter12.Element;

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