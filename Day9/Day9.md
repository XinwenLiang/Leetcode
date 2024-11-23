# 代码随想录算法训练营第九天
## [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/description/)

Given an input string `s`, reverse the order of the **words**.

A **word** is defined as a sequence of non-space characters. The **words** in `s` will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

**Note** that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

**Example1**

**Input:** s = "  hello world  "<br>
**Output:** "world hello"<br>
**Explanation:** Your reversed string should not contain leading or trailing spaces.

**Ideas:**<br>
* Remove extra spaces in the string `s`.
* Reverse the whole string `s`.
* Reverse each word in the string.

```Java
public class ReverseWords {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        // Remove extra spaces.
        chars = RemoveSpaces(chars);
        // Reverse the whole string.
        reverse(chars, 0, chars.length - 1);
        // Reverse each word.
        reverseEachWord(chars);
        return new String(chars);
    }

    public char[] RemoveSpaces(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            // Use fast to remove all the spaces.
            if (chars[fast] != ' ') {
                // Use slow to add spaces in the end of each word.
                if (slow != 0)
                    chars[slow++] = ' ';
                while (fast < chars.length && chars[fast] != ' ')
                    chars[slow++] = chars[fast++];
            }
        }
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }

    public void reverse(char[] chars, int left, int right) {
        if (right >= chars.length) {
            System.out.println("Set a wrong right.");
            return;
        }
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public void reverseEachWord(char[] chars){
        int start = 0;
        for(int end = 0; end <= chars.length; end++){
            if(end == chars.length || chars[end] == ' '){
                reverse(chars,start, end-1);
                start = end + 1;
            }
        }
    }
}
```
