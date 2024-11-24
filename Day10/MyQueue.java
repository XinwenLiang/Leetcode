package Day10;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    // Initialise the data structure
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // Push element x to the back of queue.
    public void push(int x) {
        stackIn.push(x);
    }

    // Remove the element from in front of queue and returns that element.
    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }

    // If stackOut is empty, put all the element in stackIn into stackOut.
    public void dumpstackIn(){
        if(! stackOut.isEmpty()) return;
        while(! stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }

    // Return the front element.
    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    // Check if the queue is empty.
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
