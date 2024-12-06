package Day24;

import java.util.ArrayList;
import java.util.List;

public class ValidIP {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result; // Trimming.
        backtracking(s, 0, 0);
        return result;
    }

    public void backtracking(String s, int startIndex, int pointSum) {
        if (pointSum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointSum++;
                backtracking(s, i + 2, pointSum);
                pointSum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }else{
                break;
            }
        }
    }

    public boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
