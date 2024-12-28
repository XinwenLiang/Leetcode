# 代码随想录算法训练营第四十五天
## [115. Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/description/)

Given two strings `s` and `t`, return *the number of distinct subsequences of s which equals t*.

The test cases are generated so that the answer fits on a 32-bit signed integer.

**Example 1:**

**Input:** s = "rabbbit", t = "rabbit" <br>
**Output:** 3 <br>
**Explanation:** <br>
As shown below, there are 3 ways you can generate "rabbit" from s. <br>
**rabb**b**it** <br>
**rab**b**bit** <br>
**ra**b**bbit**

**Ideas:**
1. Define the dp Array and Its Index Meaning
   dp[i][j] represents the number of occurrences of t ending with j-1 in s ending with i-1.
2. Determine the Recurrence Relation (State Transition Equation)
   ```Java
   if(s[i-1] == t[j-1]) dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
   else dp[i][j] = dp[i-1][j];
   ```
3. Initialize the dp array.
   dp[i][0] = 1; dp[0][0] = 1; dp[0][j] = 0;
4. Determine the Traversal Order
   traverse from left to right and from up to down.

```Java
public class DistinctSequences {
    public int numDistinct(String s, String t) {
        char[] nums1 = s.toCharArray();
        char[] nums2 = t.toCharArray();
        int [][] dp = new int[nums1.length +1][nums2.length + 1];
        // Initialize the dp array.
        dp[0][0] = 1;
        for (int i = 0; i < nums1.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < nums1.length +1; i++) {
            for (int j = 1; j < nums2.length +1; j++) {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
```

## [583. Delete Operation for Two Strings](https://leetcode.com/problems/delete-operation-for-two-strings/description/)

Given two strings `word1` and `word2`, return *the minimum number of steps required to make `word1` and `word2` the same*.

In one step, you can delete exactly one character in either string.

**Example 1:**

**Input:** word1 = "sea", word2 = "eat" <br>
**Output:** 2 <br>
**Explanation:** You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

**Ideas:**
1. Define the dp Array and Its Index Meaning
   dp[i][j] represents the minimum number of operations required to make word1, ending with i−1, the same as word2, ending with j−1.
2. Determine the Recurrence Relation (State Transition Equation)
   if(word1[i-1] == word2[j-1]) dp[i][j] = dp[i-1][j-1];//No delete operation.
   else dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1,dp[i-1][j-1]+2)
3. Initialize the dp array.
   dp[i][0] = i; dp[0][j] = j;
4. Determine the Traversal Order
   traverse from left to right and from up to down.

```Java
public class DeleteOperation {
    public int minDistance(String word1, String word2) {
        char[] nums1 = word1.toCharArray();
        char[] nums2 = word2.toCharArray();
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // Initialize the dp array.
        for (int i = 0; i <= nums1.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= nums2.length; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
```

## [72. Edit Distance](https://leetcode.com/problems/edit-distance/description/)

Given two strings `word1` and `word2`, return *the minimum number of operations required to convert word1 to word2*.

You have the following three operations permitted on a word:
* Insert a character
* Delete a character
* Replace a character
 
**Example 1:**

**Input:** word1 = "horse", word2 = "ros" <br>
**Output:** 3<br>
**Explanation:** <br> 
horse -> rorse (replace 'h' with 'r') <br>
rorse -> rose (remove 'r')<br>
rose -> ros (remove 'e')

**Ideas:**
1. Define the dp Array and Its Index Meaning
   dp[i][j] represents the minimum number of operations required to make word1, ending with i−1, the same as word2, ending with j−1.
2. Determine the Recurrence Relation (State Transition Equation)
   if(word1[i-1] == word2[j-1]) dp[i][j] = dp[i-1][j-1];//No delete operation.
   else dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1,dp[i-1][j-1]+1)
   Because delete an element in one array just the same as add an element in another array. dp[i-1][j-1]+1 models the replace operation.
3. Initialize the dp array.
   dp[i][0] = i; dp[0][j] = j;
4. Determine the Traversal Order
   traverse from left to right and from up to down.

```Java
public class EditDistance {
    public int minDistance(String word1, String word2) {
        char[] nums1 = word1.toCharArray();
        char[] nums2 = word2.toCharArray();
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i <= nums1.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= nums2.length ; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= nums1.length ; i++) {
            for (int j = 1; j <= nums2.length ; j++) {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
```



























