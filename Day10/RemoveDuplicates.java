package Day10;

import java.util.ArrayDeque;

public class RemoveDuplicates {
    public String removeDuplicates(String s){
        ArrayDeque<Character> result = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if(result.isEmpty() || ch != result.peek()){
                result.push(ch);
            }
            else{
                result.pop();
            }
        }
        String str = "";
        while(!result.isEmpty()){
            str = result.pop() + str;
        }
        return str;
    }
}
