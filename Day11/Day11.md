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
































