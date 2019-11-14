package semester1.chapter16.Task2;

public class List {
    public Element head;

    public List() {
        // no head
    }

    public List(Element head) {
        this.head = head;
    }

    public List push(Element element) {
        element.next = head;
        head = element;

        return this;
    }

    public List remove(int value) {
        remove(value, head, null);
        return this;
    }

    private void remove(int value, Element current, Element previous) {
        if(current != null) {
            if(current.value == value) {
                previous.next = current.next;
            } else {
                previous = current;
                current = current.next;
                remove(value, current, previous);
            }
        }
    }

    public Element get(int value) {
        return get(value, head);
    }

    private Element get(int value, Element element) {
        if(element == null) return null;

        if(element.value != value) { return get(value, element.next); } 
        else return element;
    }
}