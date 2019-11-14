package semester1.chapter16.Task7;

public class Tower {

    public int[] elements;
    public int index = 0;

    public Tower(int height) {
        elements = new int[height];
    }

    public Tower(int height, boolean isPrepared) {
        elements = new int[height];
        if(isPrepared) for(int i = height; i > 0; i--) push(i);
    }

    public void push(int number) {
        elements[index++] = number;
    }

    public int pop() {
        int number = elements[--index];
        elements[index] = 0;
        return number;
    }
}