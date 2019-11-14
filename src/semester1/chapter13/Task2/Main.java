package semester1.chapter13.Task2;

public class Main {
    public static void main(String[] args) {
        GrowableStack gs = new GrowableStack(3);
        gs.push(1);
        gs.push(3);
        gs.push(3);
        gs.push(7);
        System.out.println(gs.pop());
        gs.push(8);
    }
}