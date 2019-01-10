package chapter12.Task4;

public class List {

    Element head;

    public List push(Element element) {
        if(head != null) {
            element.next = head;
            head.prev = element;
        }

        head = element;

        return this;
    }

    public List remove(int value) {
        Element element = head;
        while(element != null && value != element.value) element = element.next;

        if(element != null) {
            if(element.prev != null) element.prev.next = element.next;
            if(element.next != null) element.next.prev = element.prev;

            if(element == head) head = element.next;
        }

        return this;
    }
}