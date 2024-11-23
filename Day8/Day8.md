# 代码随想录算法训练营第八天
## [344. Reverse String](https://leetcode.com/problems/reverse-string/description/)

Write a function that reverses a string. The input string is given as an array of characters `s`.

You must do this by modifying the input array in-place with `O(1)` extra memory.

**Example 1:**

**Input:** s = ["h","e","l","l","o"]<br>
**Output:** ["o","l","l","e","h"]

**Ideas:** This problem is relatively simple. Considering that we have previously worked on similar problems involving reversing linked lists and arrays, it's straightforward to think of using the two-pointer method. The two pointers are positioned at the beginning and the end, and they move toward the center simultaneously.

```Java
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
```

## [541. Reverse String II](https://leetcode.com/problems/reverse-string-ii/description/)

Given a string `s` and an integer `k`, reverse the first `k` characters for every `2k` characters counting from the start of the string.

If there are fewer than `k` characters left, reverse all of them. If there are less than `2k` but greater than or equal to `k` characters, then reverse the first `k` characters and leave the other as original.

**Example 1:**

**Input:** s = "abcdefg", k = 2 <br>
**Output:** "bacdfeg"

**Idea:** The difficulty of this problem lies in handling the relatively complex rules for reversal. During the traversal, we can make `i` jump `2k` steps at a time. First, handle the segment from `i` to `i + k`, then compare the remaining tail length with `k`. If the tail length is greater than `k`, reverse the first `k` elements and leave the rest unchanged; if it is less than `k`, reverse the entire remaining segment.

```Java
public class ReverseString02 {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i += 2*k){
             int left = i;
             // Check if the tail has k elements to reverse.
             int right = Math.min(ch.length-1, left+k-1);
             while(left < right){
                 char temp = ch[left];
                 ch[left] = ch[right];
                 ch[right] = temp;
                 left++;
                 right--;
             }
        }
        return new String(ch);
    }
}
```

## [54. Replace Numbers](https://kamacoder.com/problempage.php?pid=1064)

Given a string `s` that contains lowercase letters and digit characters, write a function to replace each digit character in the string with `"number"` while keeping the letter characters unchanged. 

**Example1:**

**Input:** a1b2c3<br>
**Output:** anumberbnumbercnumber

```Java
public class ReplaceNumber {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String s = myScanner.next();
        int len = s.length();
        // Get the size of new array.
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                len += 5; // If the element is a number, it will increase the space by 5.
            }
        }
        char[] result = new char[len];
        // Copy the original string s.
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i);
        }
        // Iterate the new char array from the end to the beginning.
        for (int i = s.length() - 1, j = len - 1; i >= 0; i--) {
            if (result[i] >= '0' && result[i] <= '9') {
                result[j--] = 'r';
                result[j--] = 'e';
                result[j--] = 'b';
                result[j--] = 'm';
                result[j--] = 'u';
                result[j--] = 'n';
            } else {
                result[j--] = result[i];
            }
        }
        System.out.println(result);
    }
}
```

## The light which puts out our eyes is darkness to us. Only that day dawns to which we are awake. There is more day to dawn. The sun is but a morning star.

<p align="center">
  <img src="https://github.com/user-attachments/assets/1a9ee541-c3d9-4b5c-9588-8f373611ac6f" alt="图片3" width="600">
</p>




























