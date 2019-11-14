package semester1.chapter11.Task5;

public class Main {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(new Element[]{ new Element(0, "Test1"), new Element(9, "Test2")});
        queue.push(new Element(4, "Test3"));
        queue.push(new Element(4, "Test4"));
        System.out.println(queue.get().priority);
    }
}