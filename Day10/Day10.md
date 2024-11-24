# 代码随想录算法训练营第十天
## [232. Implement Queue Using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/description/)

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

**Ideas:** To simulate queue behavior using stacks, two stacks are needed: an input stack and an output stack. When pushing, simply push all elements onto the input stack. For popping, check whether the output stack is empty. If the output stack is empty, transfer all data from the input stack to the output stack and then pop one element at a time. If the output stack is not empty, directly pop data from the output stack. The detailed animation demonstration is as follows:(from (https://github.com/youngyangyang04/leetcode-master))

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

## [225. Implement Stack Using Queues](https://leetcode.com/problems/implement-stack-using-queues/description/)

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (`push`, `top`, `pop`, and `empty`).

Implement the MyStack class:

* `void push(int x)` Pushes element x to the top of the stack.
* `int pop()` Removes the element on the top of the stack and returns it.
* `int top()` Returns the element on the top of the stack.
* `boolean empty()` Returns true if the stack is empty, false otherwise.

**Notes:**

* You must use **only** standard operations of a queue, which means that only `push to back`, `peek/pop from front`, `size` and `is empty` operations are valid.
* Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 

**Example 1:**

**Input**<br>
["MyStack", "push", "push", "top", "pop", "empty"]<br>
[[], [1], [2], [], [], []]<br>
**Output** <br>
[null, null, null, 2, 2, false]<br>

**Explanation** <br>
MyStack myStack = new MyStack();<br>
myStack.push(1);<br>
myStack.push(2);<br>
myStack.top(); // return 2<br>
myStack.pop(); // return 2<br>
myStack.empty(); // return False

**Ideas:**
We can implement stack operations using two queues, but here we use a single queue to implement a stack. The key operation is `pop`. The idea is to remove the first `size - 1` elements from the queue and reinsert them back into the queue. This way, the `size-th` element will be at the front of the queue, ready to be popped.

```Java
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
```
## [20. Valid Parentheses ](https://leetcode.com/problems/valid-parentheses/description/)

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.
 

**Example 1:**

**Input:** s = "()"

**Output:** true

**Idea:**<br>
In this problem, our approach is as follows: when encountering a left parenthesis, we push it onto the stack; when encountering a right parenthesis, we check if it matches the top element of the stack. We only need to consider three scenarios:

1. There are extra left parentheses.
2. A right parenthesis does not match the top element of the stack.
3. A right parenthesis is encountered when the stack is already empty.

```Java
public class ValidParentheses {
    public boolean isValid(String s){
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '('){
                deque.push(')');
            }else if(ch == '['){
                deque.push(']');
            }else if(ch == '{'){
                deque.push('}');
            }else if(deque.isEmpty() || deque.peek() != ch){
                return false;
            }else{ // If it's right parentheses, check if it can be matched with the top of stack.
                deque.pop();
            }
        }
        return deque.isEmpty();
    }
}
```

































