# 代码随想录算法训练营第十一天

## [150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/)

You are given an array of strings `tokens` that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

**Note** that:

* The valid operators are `'+'`, `'-'`, `'*'`, and `'/'`.
* Each operand may be an integer or another expression.
* The division between two integers always **truncates toward** zero.
* There will not be any division by zero.
* The input represents a valid arithmetic expression in a reverse polish notation.
* The answer and all the intermediate calculations can be represented in a **32-bit** integer.
 

**Example 1:**

**Input:** tokens = ["2","1","+","3","*"]<br>
**Output:** 9<br>
**Explanation:** ((2 + 1) * 3) = 9

**Ideas:** We solve this problem using a stack. Traverse the entire string, pushing numbers onto the stack when encountered. When an operator is encountered, pop two elements from the stack, perform the operation, and push the result back onto the stack. Finally, the result we need will be the top element of the stack.

```Java
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String s : tokens){
            if("+".equals(s)){
                stack.push(stack.pop() + stack.pop());
            }
            else if("-".equals(s)){//Note the sign.
                stack.push(-stack.pop() + stack.pop());
            }else if ("*".equals(s)){
                stack.push(stack.pop() * stack.pop());
            }else if("/".equals(s)){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2/temp1);
            }else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
```

## [239.Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/description/)

You are given an array of integers `nums`, there is a sliding window of size `k` which is moving from the very left of the array to the very right. You can only see the `k` numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

**Example 1:**

**Input:** nums = [1,3,-1,-3,5,3,6,7], k = 3<br>
**Output:** [3,3,5,5,6,7]<br>
**Explanation:** <br> 
Window position                Max<br>
---------------               -----<br>
[1  3  -1] -3  5  3  6  7       3<br>
 1 [3  -1  -3] 5  3  6  7       3<br>
 1  3 [-1  -3  5] 3  6  7       5<br>
 1  3  -1 [-3  5  3] 6  7       5<br>
 1  3  -1  -3 [5  3  6] 7       6<br>
 1  3  -1  -3  5 [3  6  7]      7<br>

 **Ideas:**<br>
 This problem requires us to implement a custom monotonic stack that supports the functions `pop`, `push`, and `getMaxValue`.

* `pop` function: If the element value removed from the window equals the element at the exit of the monotonic queue, the queue pops the element. Otherwise, no action is needed.
* `push` function: If the element value to be pushed is greater than the value of the element at the entrance of the queue, the queue continues popping elements from the entrance until the value of the pushed element is less than or equal to the value of the element at the entrance.
* `getMaxValue` function: Simply retrieve the top element of the stack each time.

And here is the process(From https://github.com/youngyangyang04/leetcode-master)

![239.滑动窗口最大值-2](https://code-thinking.cdn.bcebos.com/gifs/239.滑动窗口最大值-2.gif)

```Java
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
```

## [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/description/)

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements. You may return the answer in any order.

**Example 1:**

**Input:** nums = [1,1,1,2,2,3], k = 2<br>
**Output:** [1,2]

**Ideas:** <br>
Since this problem requires comparing the frequency of elements, we consider using a map data structure to store information about the input array. The key represents the array elements, and the value represents their frequency. Then, we use a min-heap to traverse the elements in the map. This way, when we pop, the top element is removed, leaving the elements with higher frequencies in the heap. Finally, we can generate the required array in reverse order.

```Java
public class TopKElement {
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num :nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2) -> pair1[1] -pair2[1]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(pq.size() < k){
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }else{
                if (entry.getValue() > pq.peek()[1]) {
                    pq.poll(); // Pop the root node.
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] result = new int[k];
        for (int i = k-1; i >=0 ; i--) {
            result[i] = pq.poll()[0];
        }
        return result;
    }
}
```






























