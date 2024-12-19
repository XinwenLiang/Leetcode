# 代码随想录算法训练营第三十七天
## [Coins Change II](https://leetcode.com/problems/coin-change-ii/description/)

You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money.

Return *the number of combinations that make up that amount*. If that amount of money cannot be made up by any combination of the `coins`, return `0`.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

**Example 1:**

**Input:** amount = 5, coins = [1,2,5] <br>
**Output:** 4<br>
**Explanation:** there are four ways to make up the amount:<br>
5=5<br>
5=2+2+1<br>
5=2+1+1+1<br>
5=1+1+1+1+1

**Ideas:**
1. Define the dp Array and Its Index Meaning
  The definition of `dp[j]` is: There exist dp[j] method to fill a bag with the capacity of `amount`.
2. Determine the Recurrence Relation (State Transition Equation)
 `dp[j] += dp[j-coins[i]]`
3. Initialize the dp Array
   dp[j] = 1
4. Determine the Traversal Order
  The traversal order for the complete knapsack problem can be either iterating through the items first and then the knapsack or vice versa. However, in this problem, we are calculating the number of combinations, so
  we must iterate through the items first and then the knapsack. This ensures that duplicate cases are avoided.

```Java
public class CoinsChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
```































