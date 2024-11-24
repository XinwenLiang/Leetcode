# 代码随想录算法训练营第十天
## [Implement Queue Using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/description/)

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (`push`, `peek`, `pop`, and `empty`).

Implement the `MyQueue` class:

* `void push(int x)` Pushes element x to the back of the queue.
* `int pop()` Removes the element from the front of the queue and returns it.
* `int peek()` Returns the element at the front of the queue.
* `boolean empty()` Returns `true` if the queue is empty, `false` otherwise.<br>
**Notes:**

* You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
* Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

**Example 1:**

**Input**<br>
["MyQueue", "push", "push", "peek", "pop", "empty"]<br>
[[], [1], [2], [], [], []]<br>
**Output** <br>
[null, null, null, 1, 1, false]

**Explanation**<br>
MyQueue myQueue = new MyQueue();<br>
myQueue.push(1); // queue is: [1]<br>
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)<br>
myQueue.peek(); // return 1<br>
myQueue.pop(); // return 1, queue is [2]<br>
myQueue.empty(); // return false<br>

**Ideas:** To simulate queue behavior using stacks, two stacks are needed: an input stack and an output stack. When pushing, simply push all elements onto the input stack. For popping, check whether the output stack is empty. If the output stack is empty, transfer all data from the input stack to the output stack and then pop one element at a time. If the output stack is not empty, directly pop data from the output stack. The detailed animation demonstration is as follows:(from https://github.com/XinwenLiang/leetcode-master/blob/master/problems/0232.%E7%94%A8%E6%A0%88%E5%AE%9E%E7%8E%B0%E9%98%9F%E5%88%97.md)

![232.用栈实现队列版本2](https://code-thinking.cdn.bcebos.com/gifs/232.用栈实现队列版本2.gif)

```Java
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
```



























