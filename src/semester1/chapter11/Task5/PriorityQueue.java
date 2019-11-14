package semester1.chapter11.Task5;

public class PriorityQueue {
    public Element[] queue;

    public PriorityQueue() {
        queue = new Element[0];
    }

    public PriorityQueue(Element[] queue) {
        this.queue = queue;
        sort();
    }

    private void sort() {
        for(int i = 0; i < queue.length; i++) {
            for(int j = i; j < queue.length; j++) {
                if(queue[i].priority < queue[j].priority) {
                    Element element = queue[j];
                    queue[j] = queue[i];
                    queue[i] = element;
                }
            }
        }
    }

    public Element get() {
        if(queue.length > 0) return queue[0];
        else return null;
    }

    public PriorityQueue push(Element element) {
        Element[] newQueue = new Element[queue.length + 1];

        for(int i = 0; i < queue.length; i++) {
            newQueue[i] = queue[i];
        }

        newQueue[queue.length] = element;
        queue = newQueue;

        sort();

        return this;
    }
}