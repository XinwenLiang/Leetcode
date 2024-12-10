# 代码随想录算法训练营第二十八天
## [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/)

You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

On each day, you may decide to buy and/or sell the stock. You can only hold **at most one** share of the stock at any time. However, you can buy it then immediately sell it on the **same day**.

Find and return the ***maximum*** profit you can achieve.

**Example 1:**

**Input:** prices = [7,1,5,3,6,4] <br>
**Output:** 7 <br>
**Explanation:** Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.<br>
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.<br>
Total profit is 4 + 3 = 7.

**Ideas:** We need to calculate the profit between two days. If profit is negative, we skip that day. If profit is positive, we add it to our result.

```Java
public class StockProfit {
    public int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 1; i < prices.length ; i++) {
            count += Math.max(prices[i] - prices[i-1],0);
        }
        return count;
    }
}
```

## [55. Jump Game](https://leetcode.com/problems/jump-game/description/)

You are given an integer array `nums`. You are initially positioned at the array's **first index**, and each element in the array represents your maximum jump length at that position.

Return `true` if you can reach the last index, or `false` otherwise.

**Example 1:**

**Input:** nums = [2,3,1,1,4]<br>
**Output:** true <br>
**Explanation:** Jump 1 step from index 0 to 1, then 3 steps to the last index.

**Ideas:** One local optimal approach we can consider is to select the largest coverage range each time. If the largest coverage range can cover the key point, return `true`; otherwise, return `false`.

```Java
public class JumpGame {
    public boolean canJump(int[] nums) {
        int cover = 0;
        if(nums.length == 1){
            return true;
        }
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i+ nums[i], cover);
            if(cover >= nums.length - 1) return true;
        }
        return false;
    }
}
```

## [Jump Game II](https://leetcode.com/problems/jump-game-ii/)

You are given a **0-indexed** array of integers `nums` of length `n`. You are initially positioned at `nums[0]`.

Each element `nums[i]` represents the maximum length of a forward jump from index `i`. In other words, if you are at `nums[i]`, you can jump to any `nums[i + j]` where:

* 0 <= j <= nums[i] and
* i + j < n
Return *the minimum number of jumps to reach* `nums[n - 1]`. The test cases are generated such that you can reach `nums[n - 1]`.

 

**Example 1:**

**Input:** nums = [2,3,1,1,4] <br>
**Output:** 2 <br>
**Explanation:** The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

**Ideas:** Greedy approach: At each step, maximize the coverage range until the endpoint is covered, and output the number of steps.

```Java
public class JumpGameII {
    public int jump(int[] nums) {
        int cur = 0;
        int next = 0;
        int result = 0;
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            next = Math.max(i + nums[i], next);
            // Move to the next step can cover the end point.
            if (next >= nums.length - 1) {
                result++;
                break;
            }
            if (i == cur) {
                cur = next;
                result++;
            }
        }
        return result;
    }
}
```



























