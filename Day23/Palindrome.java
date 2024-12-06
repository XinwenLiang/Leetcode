package Day23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Palindrome {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s,0,new StringBuilder());
        return res;
    }
    public void backtracking(String s, int startIndex, StringBuilder sb){
        if (startIndex == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <s.length() ; i++) {
            sb.append(s.charAt(i));
            if(isPalindrome(sb)){
                path.add(sb.toString());
                backtracking(s,i+1,new StringBuilder());
                path.remove(path.size() - 1);
            }
        }
    }
    public boolean isPalindrome(StringBuilder sb){
        for (int i = 0; i < sb.length()/2; i++) {
            if(sb.charAt(i) != sb.charAt(sb.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
