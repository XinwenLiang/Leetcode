# 代码随想录算法训练营第四十四天
## [1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/description/)

Given two strings `text1` and `text2`, return the length of their longest **common subsequence**. If there is no **common subsequence**, return `0`.

A **subsequence** of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
* For example, `"ace"` is a subsequence of `"abcde"`.

A **common subsequence** of two strings is a subsequence that is common to both strings.

**Example 1:**

**Input:** text1 = "abcde", text2 = "ace" <br> 
**Output:** 3 <br>  
**Explanation:** The longest common subsequence is "ace" and its length is 3.

**Ideas:**
1. Define the dp Array and Its Index Meaning
   dp[i][j] represents the length of the longest repeated subarray ending in nums1[i-1] and nums2[j-1].
2. Determine the Recurrence Relation (State Transition Equation)
   ```Java
   if(nums1[i-1] == nums2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
   else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
   ```
3. Initialize the dp array.
   dp[i][0] = dp[0][j] = 0;
4. Determine the Traversal Order
   traverse from left to right and from up to down.

```Java
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] nums1 = text1.toCharArray();
        char[] nums2 = text2.toCharArray();
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // Initialize the dp array.
        for (int i = 0; i < nums1.length + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < nums2.length + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
```

## [1035. Uncrossed Lines](https://leetcode.com/problems/uncrossed-lines/description/)

You are given two integer arrays `nums1` and `nums2`. We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.

We may draw connecting lines: a straight line connecting two numbers `nums1[i]` and `nums2[j]` such that:

* nums1[i] == nums2[j], and
* the line we draw does not intersect any other connecting (non-horizontal) line.

Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong to one connecting line).

Return *the maximum number of connecting lines we can draw in this way*.

**Example 1:**

![image](https://github.com/user-attachments/assets/5dd6340d-2a2c-4b26-9ac7-c0eabac6f08e)

**Input:** nums1 = [1,4,2], nums2 = [1,2,4] <br>
**Output:** 2 <br>
**Explanation:** We can draw 2 uncrossed lines as in the diagram. <br>
We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.

**Ideas:**
To find the maximum number of non-intersecting lines, it essentially boils down to finding the length of the longest common subsequence. It’s the same as the previous problem.

```Java
public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length +1][nums2.length+1];
        for (int i = 0; i < nums1.length+1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < nums2.length+1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
```






































