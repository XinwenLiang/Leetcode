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

## [55.Right Rotate String](https://kamacoder.com/problempage.php?pid=1065)

The right rotation operation of a string moves the last `k` characters of the string to the front. Given a string `s` and a positive integer `k`, write a function to perform the right rotation operation on the string. 

**Example1:**

**Input:** k = 2, s ="abcdefg"

**Output:** "fgabcde"

**Ideas:**

Similar to the previous problem, we divide the string into two parts using the positive integer `k`: the first `n-k` characters and the last `k` characters. First, we reverse the entire string, and then we reverse the first `k` characters and the last `n-k` characters separately. This gives us the desired result.

```Java
import java.util.Scanner;

public class RightRotate {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = Integer.parseInt(myScanner.nextLine());
        String s = myScanner.nextLine();

        int len = s.length();
        char[] ch = s.toCharArray();
        reverseString(ch, 0, len - 1);
        reverseString(ch, 0, n - 1);
        reverseString(ch, n, len - 1);
        System.out.println(ch);
    }

    public static void reverseString(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
```

## Miracles happen every day.

<p align="center">
  <img src="https://github.com/user-attachments/assets/f47eea66-df8a-4712-9d77-475a78e36f50" alt="图片3" width="600">
</p>


























