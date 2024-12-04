package Day22;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumCombinations {
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return result;
        // Map characters to numbers
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return result;
    }

    StringBuilder temp = new StringBuilder();
    public void backTracking(String digits, String[] numString, int index) {
        if (index == digits.length()) {
            result.add(temp.toString());
            return;
        }
        String str = numString[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(digits, numString, index+1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
