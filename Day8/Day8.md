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
































