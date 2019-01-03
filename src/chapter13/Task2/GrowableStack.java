package chapter13.Task2;

public class GrowableStack extends Stack {
    
    public GrowableStack(int size) {
        super(size);
    }

    public Stack push(int value) {

        length++;
        
        if(length > stack.length) { 
            int[] tempStack = new int[length * 2];

            for(int i = 0; i < length - 1; i++) {
                tempStack[i] = stack[i];
            }

            stack = tempStack;
        }

        stack[length - 1] = value;

        return this;
    }

    public int pop() {
        length--;

        stack[length] = 0; 

        return stack[length - 1];
    }

    public int getLength() {
        return length;
    }
}