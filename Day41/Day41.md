# 代码随想录算法训练营第四十一天
## [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return *the maximum profit you can achieve from this transaction*. If you cannot achieve any profit, return `0`.

**Example 1:**

**Input:** prices = [7,1,5,3,6,4] <br>
**Output:** 5 <br>
**Explanation:** Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. <br>
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

**Ideas:**
1. Define the dp Array and Its Index Meaning
 * dp[i][0] represents the maximum amount of shares held.
 * dp[i][1] represents the maximum amount without shareholding
2. Determine the Recurrence Relation (State Transition Equation)
 * dp[i][0] = Math.max(dp[i-1][0],-prices[i])
 * dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i])
3. Initialize the dp array.
   dp[0][0] = -prices[0]; dp[0][1] = 0;
4. Determine the Traversal Order
   traverse from front to back

```Java
public class ShareHolder {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0]; // We bought the share at the first day.
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[len-1][1];
    }
}
```
   
## [122. Best Time to Buy and Sell StockII](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/)

You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return *the maximum profit you can achieve*.

**Example 1:**

**Input:** prices = [7,1,5,3,6,4]
**Output:** 7
**Explanation:** Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.<br>
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.<br>
Total profit is 4 + 3 = 7.

**Ideas:**
1. Define the dp Array and Its Index Meaning
 * dp[i][0] represents the maximum amount of shares held.
 * dp[i][1] represents the maximum amount without shareholding
2. Determine the Recurrence Relation (State Transition Equation)
 * dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i])
 * dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i])
3. Initialize the dp array.
   dp[0][0] = -prices[0]; dp[0][1] = 0;
4. Determine the Traversal Order
   traverse from front to back

```Java
// Greedy Method
class Solution {
    public int maxProfit(int[] prices) {
         int count = 0;
        for (int i = 1; i < prices.length ; i++) {
            count += Math.max(prices[i] - prices[i-1],0);
        }
        return count;
    }
}

// Dynamic programming
public class ShareHolderII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
```































