# 代码随想录算法训练营第三十八天
## [279. Perfect Squares](https://leetcode.com/problems/perfect-squares/description/）

Given an integer `n`, return *the least number of perfect square numbers that sum to n*.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

**Example 1:**

**Input:** n = 12 <br>
**Output:** 3<br>
**Explanation:** 12 = 4 + 4 + 4.<br>

**Ideas**
1. Define the dp Array and Its Index Meaning
  The definition of `dp[j]` is: The minimum number of perfect squares that sum up to j.
2. Determine the Recurrence Relation (State Transition Equation)
 `dp[j] = Math.min(dp[j],dp[j-i*i])`
3. Initialize the dp Array
   dp[0] = 0; Initialize the number to be the maximum.
4. Determine the Traversal Order
   Both are ok.

```Java
public class PerfectNums {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i*i <= n; i++) {
            for (int j = i*i; j <= n; j++) {
                dp[j] = Math.min(dp[j-i*i] + 1, dp[j]);
            }
        }
        return dp[n];
    }
}
```

## [139. Word Break](https://leetcode.com/problems/word-break/description/)

Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.

**Note** that the same word in the dictionary may be reused multiple times in the segmentation.

**Example 1:**

**Input:** s = "leetcode", wordDict = ["leet","code"] <br>
**Output:** true<br>
**Explanation:** Return true because "leetcode" can be segmented as "leet code".

**Ideas:**
1. Define the dp Array and Its Index Meaning
  i represents the length of `s`, and dp[i] = true means we can divide the string to several words.
2. Determine the Recurrence Relation (State Transition Equation)
   if([j,i] && dp[i] == true, then dp[i] = true;
3. Initialize the dp Array
   dp[0] = true;
4. Determine the Traversal Order
   In this problem, we emphasize the order of the words, so it is a permutation scenario. Therefore, we need to iterate through the backpack first, followed by iterating through the items.

   ```Java
   public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for (int j = 0; j < i; j++) {
                if(set.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
```






































