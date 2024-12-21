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
  * If rob house `i`, `dp[i] = dp[i-2] + nums[i]`;
  * If not rob house `i`, `dp[i] = dp[i-1]`
2. Determine the Recurrence Relation (State Transition Equation)
 `dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1])`
3. Initialize the dp Array
   `dp[0] = nums[0]`, `dp[1] = Math.max(nums[0], nums[1])`.
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

## [213. House Robber II](https://leetcode.com/problems/house-robber-ii/description/)

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are **arranged in a circle**. That means the first house is the neighbor 
of the last one. Meanwhile, adjacent houses have a security system connected, and **it will automatically contact the police if two adjacent houses were broken into on the same night**.

Given an integer array `nums` representing the amount of money of each house, return *the maximum amount of money you can rob tonight without alerting the police*.

**Example 1:**

**Input:** nums = [2,3,2] <br>
**Output:** 3<br>
**Explanation:** You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

**Ideas:**
For this problem, we need to consider three cases:
* Exclude both the first and last elements.
* Include the first element but exclude the last.
* Include the last element but exclude the first.
However, the first case is actually covered by the latter two cases, so we only need to consider cases 2 and 3. Then, based on the solution for the first problem, we can simply extract the relevant subarrays for
calculation.

```Java
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int len = nums.length;
        return Math.max(robAction(nums,0, len-1), robAction(nums,1, len));
    }
    int robAction(int[] nums, int start, int end){
        int temp1 = 0;
        int temp2 = 0;
        int result = 0;
        for (int i = start; i < end; i++) {
            temp1 = result;
            result = Math.max(temp2 + nums[i], temp1);
            temp2 = temp1;
        }
        return result;
    }
}
```

## [


























