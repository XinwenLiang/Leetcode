package Day10;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;

    public MyStack(){
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop(){
        rePosition();
        return queue.poll();
    }

    public int top(){
        rePosition();
        int result = queue.poll();
        queue.add(result);
        return result;
    }

    public boolean empty(){
        return queue.isEmpty();
    }

    public void rePosition(){
        int size = queue.size();
        size--;
        while(size-- > 0){
            queue.add(queue.poll());
        }
    }
}
