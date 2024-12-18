# 代码随想录算法训练营第三十六天
## [1049. Last Stone Weight II](https://leetcode.com/problems/last-stone-weight-ii/description/)

You are given an array of integers `stones` where `stones[i]` is the weight of the `ith` stone.

We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights `x` and `y` with `x <= y`. The result of this smash is:
* If `x == y`, both stones are destroyed, and
* If `x != y`, the stone of weight `x` is destroyed, and the stone of weight `y` has new weight `y - x`.
At the end of the game, there is **at most one stone** left.

Return *the smallest possible weight of the left stone*. If there are no stones left, return  `0`.

**Example 1:**

**Input:** stones = [2,7,4,1,8,1] <br>
**Output:** 1 <br>
**Explanation:** <br>
We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then, <br>
we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,<br>
we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,<br>
we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.

**Ideas:**
1. Define the dp Array and Its Index Meaning
  The definition of `dp[j]` is: the maximum weight that can be achieved by selecting stones from the range (0, i) to be smashed with capacity j.
* Not placing item i: The value remains dp[j].
* Placing item i: The value is dp[j-stones[i] + stones[i].
2. Determine the Recurrence Relation (State Transition Equation)
  Since we want to maximize the total value of the backpack within its capacity, we take the maximum of the two cases. The recurrence relation is:
  `dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i])`
3. Initialize the dp Array
   dp[j] = 0, when the capacity of bag is 0, the maximal weight of this bag is 0 too.
4. Determine the Traversal Order
  We can only use reverse iteration to ensure that each item is used only once.

  ``` Java
  public class LastStonesWeight {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}
```

## [494. Target Sum](https://leetcode.com/problems/target-sum/description/)

You are given an integer array `nums` and an integer `target`.

You want to build an **expression** out of nums by adding one of the symbols `'+'` and `'-'` before each integer in nums and then concatenate all the integers.
* For example, if `nums = [2, 1]`, you can add a `'+'` before `2` and a `'-'` before `1` and concatenate them to build the expression `"+2-1"`.

Return *the number of different expressions that you can build, which evaluates to target*.

**Example 1:**

**Input:** nums = [1,1,1,1,1], target = 3<br>
**Output:** 5<br>
**Explanation:** There are 5 ways to assign symbols to make the sum of nums be target 3. <br>
-1 + 1 + 1 + 1 + 1 = 3<br>
+1 - 1 + 1 + 1 + 1 = 3<br>
+1 + 1 - 1 + 1 + 1 = 3<br>
+1 + 1 + 1 - 1 + 1 = 3<br>
+1 + 1 + 1 + 1 - 1 = 3

**Ideas:** 
In this problem, we need to determine the combinations of additions and subtractions separately. Assume the total sum of the additions is `x`, then the corresponding total sum of the subtractions is `sum-x`,
where `sum` is the total of all numbers in the array. Our goal is to find a result such that: `x-(sum-x) = target`. Rearranging the equation, we get: `x = (target+sum)/2`.
At this point, the problem is transformed into a knapsack problem: we need to use the numbers in the array to "fill" a knapsack with a capacity of `x` and calculate how many ways it can be achieved.
Here, `x` is the bag size, which is the knapsack capacity we aim to calculate in the subsequent steps. However, there are two cases where no solution exists:
* `target+sum` cannot be evenly divided by `2`: In this case, `x` is not an integer, making the partition impossible.
* `Math.abs(target)` is greater than sum: In this case, the target exceeds the possible range of sums, making it impossible to achieve.
1. Define the dp Array and Its Index Meaning
  The definition of `dp[j]` is: There exist dp[j] methods to fill a bag with capacity of j.
2. Determine the Recurrence Relation (State Transition Equation)
 `dp[j] += dp[j-nums[i]]`
3. Initialize the dp Array
   dp[0] = 1, cause if nums={0}, we can only put one item in this bag.
4. Determine the Traversal Order
  We can only use reverse iteration to ensure that each item is used only once.

```Java
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target){
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if((sum + target) % 2 == 1 || Math.abs(target)>sum) return 0;
        int bagSize = (sum + target)/2;
        int[] dp = new int[bagSize +1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = bagSize; j >= nums[i] ; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
```

## [474. Ones and Zeros](https://leetcode.com/problems/ones-and-zeroes/description/)

You are given an array of binary strings `strs` and two integers `m` and `n`.

Return *the size of the largest subset of `strs` such that there are at most `m 0's` and `n 1's` in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.

**Example 1:**

**Input:** strs = ["10","0001","111001","1","0"], m = 5, n = 3 <br>
**Output:** 4 <br>
**Explanation:** The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.<br>
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.<br>
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.

**Ideas:**
Fisrt, we need to count how many 0's and 1's in `str`,and this represents the weight of items. And `m` and `n` represent the capacity of this bag,
1. Define the dp Array and Its Index Meaning
  The definition of `dp[i][j]` is: The size of the largest subset of strs that contains at mt most i zeros and j ones is represented by dp[i][j].
2. Determine the Recurrence Relation (State Transition Equation)
 `dp[i][j] = Math.max(dp[i-x][j-y]+1, dp[i][j])`
3. Initialize the dp Array
   dp[0] = 0.
4. Determine the Traversal Order
  We can only use reverse iteration to ensure that each item is used only once.

```Java
public class OneAndZero {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][]dp = new int[m+1][n+1];
        int x; // Record the number of 0's
        int y; // Record the number of 1's
        for(String str:strs){
            x = 0;
            y = 0;
            for(char ch :str.toCharArray()){
                if(ch == '0'){
                    x++;
                }else{
                    y++;
                }
            }
            for (int i = m; i >= x; i--) {
                for (int j = n; j >= y ; j--) {
                    dp[i][j]= Math.max(dp[i][j], dp[i-x][j-y] + 1);
                }

            }
        }
        return dp[m][n];
    }
}
```























