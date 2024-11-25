package Day11;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums.length == 1){
            return nums;
        }
        int len = nums.length;
        int[] result = new int[len-k+1];
        int num = 0;
        MyQueue que = new MyQueue();
        // Put the first k elements into the queue.
        for (int i = 0; i < k; i++) {
            que.push(nums[i]);
        }
        // Add the max value of the first window to the result.
        result[num++] = que.getMaxValue();

        // Slide the window
        for (int i = k; i < len; i++) {
            que.pop(nums[i - k]);  // Remove the element going out of the window
            que.push(nums[i]);    // Add the new element coming into the window
            result[num++] = que.getMaxValue(); // Get the max value of the current window
        }

        return result;

     }

}
class MyQueue{
    Deque<Integer> deque = new LinkedList<>();
    void pop(int val){
        if(!deque.isEmpty() && val == deque.peek()){
            deque.poll();
        }
    }

    void push(int val){
        while(!deque.isEmpty() && val > deque.getLast()){
            deque.removeLast();
        }
        deque.add(val);
    }
    int getMaxValue(){
        return deque.peek();
    }
}
