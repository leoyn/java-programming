package semester1.chapter12;

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
}