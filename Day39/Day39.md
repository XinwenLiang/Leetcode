# 代码随想录算法训练营第三十九天
## [198. House Robber](https://leetcode.com/problems/house-robber/description/)

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security 
systems connected and **it will automatically contact the police if two adjacent houses were broken into on the same night**.

Given an integer array `nums` representing the amount of money of each house, return *the maximum amount of money you can rob tonight without alerting the police*.

**Example 1:**

**Input:** nums = [1,2,3,1] <br>
**Output:** 4 <br>
**Explanation:** Rob house 1 (money = 1) and then rob house 3 (money = 3).<br>
Total amount you can rob = 1 + 3 = 4.

**Ideas:**
1. Define the dp Array and Its Index Meaning
  The definition of `dp[i]` is: Consider the maximum amount of money stolen at index `i` as `dp[i]`
  * If rob house i, dp[i] = dp[i-2] + nums[i]
  * If not rob house i, dp[i] = dp[i-1]
2. Determine the Recurrence Relation (State Transition Equation)
 `dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1])`
3. Initialize the dp Array
   dp[0] = nums[0], dp[1] = Math.max(nums[0], nums[1]).
4. Determine the Traversal Order
   The traversal order should be from smaller to larger indices.

```Java
public class RobHouse {
    public int rob(int[] nums) {
        if(nums == null|| nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int [nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length ; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
```






























