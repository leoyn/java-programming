package chapter13.Task2;

public class Stack {
    public int[] stack;
    public int length;

    public Stack(int size) {
        stack = new int[size];
        length = 0;
    }

    public Stack push(int value) {
        if(length >= stack.length) stack[length++] = value;
        return this;
    }

    public int pop() {
        if(length < 1) return -1;
        else return stack[--length];
    }
}