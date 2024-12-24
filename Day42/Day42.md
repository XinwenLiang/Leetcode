# 代码随想录算法训练营第四十二天
## [188. Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/)

You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `ith` day, and an integer `k`.

Find the maximum profit you can achieve. You may complete at most `k` transactions: i.e. you may buy at most `k` times and sell at most `k` times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

**Example 1:**

**Input:** k = 2, prices = [2,4,1]<br>
**Output:** 2<br>
**Explanation:** Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

**Ideas:**
1. Define the dp Array and Its Index Meaning
  dp[i][j]: For j: except for 0, even numbers mean "sell," and odd numbers mean "buy."
2. Determine the Recurrence Relation (State Transition Equation)
 ```Java
for (j=0;j<2k;j+=2){
   dp[i][j+1] = Math.max(dp[i-1][j+1],dp[i-1][j] - prices[i]);
   dp[i][j+2] = Math.max(dp[i-1][j+2],dp[i-1][j+1]+prices[i]);
}
```
3. Initialize the dp array.
  If j is an odd number, then dp[0][j] = -prices[0];
4. Determine the Traversal Order
   traverse from front to back

```Java
public class ShareHolderIV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2 * k + 1];
        for (int j = 1; j < 2 * k; j += 2) {
            dp[0][j] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[len - 1][2 * k];
    }
}
```

## [309. Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/)

You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).<br>
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

**Example 1:**

**Input:** prices = [1,2,3,0,2] <br>
**Output:** 3<br>
**Explanation:** transactions = [buy, sell, cooldown, buy, sell] 

**Ideas:**
1. Define the dp Array and Its Index Meaning
 * dp[i][0] represents hold the share.
 * dp[i][1] represents keep the state of selling the share.
 * dp[i][2] represents sell the share.
 * dp[i][3] represents cooldown.
2. Determine the Recurrence Relation (State Transition Equation)
 * dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i], dp[i-1][3]-prices[i])
 * dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3])
 * dp[i][2] = dp[i-1][0] + prices[i]
 * dp[i][3] = dp[i-1][2]
3. Initialize the dp array.
   dp[0][0] = -prices[i];
   dp[0][1] = 0;
   dp[0][2] = 0;
   dp[0][3] = 0;
4. Determine the Traversal Order
   traverse from front to back

```Java
public class ShareHolderWithCooldown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(Math.max(dp[i-1][0],dp[i-1][1]-prices[i]),dp[i-1][3] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }
        return Math.max(Math.max(dp[len-1][1],dp[len-1][2]),dp[len-1][3]);
    }
}
```


























