package Day10;

import java.util.Deque;
import java.util.LinkedList;

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
