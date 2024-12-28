# 代码随想录算法训练营第四十六天
## [647. Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/description/)

Given a string `s`, return *the number of palindromic substrings in it*.

A string is a **palindrome** when it reads the same backward as forward.

A **substring** is a contiguous sequence of characters within the string.

**Example 1:**

**Input:** s = "abc" <br>
**Output:** 3 <br>
**Explanation:** Three palindromic strings: "a", "b", "c".

**Ideas:**
1. Define the dp Array and Its Index Meaning
   dp[i][j] indicates whether the substring within the range [i,j]
2. Determine the Recurrence Relation (State Transition Equation)
   if(s[i] = s[j]), there are three cases:
   * i and j are the same, like "a", dp[i][j] = true;
   * j-i = 1,like "a,a" dp[i][j] = true
   * i-i > 1, then if(dp[i+1][j-1] = true, dp[i][j] can be true.
3. Initialize the dp array.
   dp[i][j] = false
4. Determine the Traversal Order
   traverse from left to right and from down to up.

```Java
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        char[] t = s.toCharArray();
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = t.length - 1; i >= 0; i--) {
            for (int j = i; j < t.length; j++) {
                if (t[i] == t[j]) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        res++;
                    } else if (i + 1 <= j - 1 && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
```

## [516. Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/description/)

Given a string `s`, find the longest palindromic subsequence's length in `s`.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

**Example 1:**

**Input:** s = "bbbab" <br>
**Output:** 4 <br>
**Explanation:** One possible longest palindromic subsequence is "bbbb".

**Ideas:**
1. Define the dp Array and Its Index Meaning
   dp[i][j] represents the length of palindromic subsequence  within the range [i,j]
2. Determine the Recurrence Relation (State Transition Equation)
   if(s[i] = s[j]), dp[i][j] = dp[i+1][j-1]+2
   else dp[i][j] = max(dp[i][j-1],dp[i+1][j])
3. Initialize the dp array.
   if(i==j) dp[i][j] = 1;
4. Determine the Traversal Order
   traverse from left to right and from down to up.

```Java
public class LongestSubsequence {
    public int longestPalindromeSubseq(String s) {
        char[] nums = s.toCharArray();
        int[][] dp = new int[nums.length][nums.length];
        // Initialize the dp array.
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = nums.length-1; i >= 0 ; i--) {
            for (int j = i+1; j < nums.length ; j++) {
                if(nums[i] == nums[j]){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][nums.length-1];
    }
}
```
   





































