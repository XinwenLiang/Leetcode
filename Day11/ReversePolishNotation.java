package Day11;

import java.util.Deque;
import java.util.LinkedList;

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
