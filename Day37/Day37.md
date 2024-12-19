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
   dp[0] = 1
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

## [377. Combination Sum IV](https://leetcode.com/problems/combination-sum-iv/description/)

Given an array of **distinct** integers `nums` and a `target` integer target, return *the number of possible combinations that add up to target*.

The test cases are generated so that the answer can fit in a 32-bit integer.

**Example 1:**

**Input:** nums = [1,2,3], target = 4 <br>
**Output:** 7<br>
**Explanation:** <br>
The possible combination ways are: <br>
(1, 1, 1, 1)<br>
(1, 1, 2)<br>
(1, 2, 1)<br>
(1, 3)<br>
(2, 1, 1)<br>
(2, 2)<br>
(3, 1)<br>
Note that different sequences are counted as different combinations.

**Ideas:** The only difference between this problem and the previous one lies in the traversal order. Since the order in which elements are taken matters in this problem, we need to traverse the knapsack first and 
then the items.

```Java
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int j = 0; j <= target; j++){
            for(int i = 0; i < nums.length;i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
```

## [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/description/)

**Ideas:**
1. Define the dp Array and Its Index Meaning
  The definition of `dp[i]` is: To achive ith stair, we have dp[i] methods.
2. Determine the Recurrence Relation (State Transition Equation)
 `dp[i] += dp[i-j]`
3. Initialize the dp Array
   dp[0] = 1
4. Determine the Traversal Order
   Since the staircase problem is about the order of steps taken, which is a permutation problem rather than a combination problem, we need to traverse the knapsack first and then the items.

   ```Java
   public class ClimbStairs {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int m = myScanner.nextInt(); // The steps we can take.
        int n = myScanner.nextInt(); // The nth stair.
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int j = 0; j<= n; j++){
            for (int i = 0; i <=m; i++) {
                if(j-i >= 0){
                    dp[j] += dp[j-i];
                }
            }
            System.out.println(dp[n]);
        }
    }
}
```


## [322. Coin Change](https://leetcode.com/problems/coin-change/description/)

You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money.

Return *the fewest number of coins that you need to make up that amount*. If that amount of money cannot be made up by any combination of the coins, return `-1`.

You may assume that you have an infinite number of each kind of coin.

**Example 1:**

**Input:** coins = [1,2,5], amount = 11 <br>
**Output:** 3<br>
**Explanation:** 11 = 5 + 5 + 1

**Ideas:**
1. Define the dp Array and Its Index Meaning
  The definition of `dp[j]` is: To fill the bag, we need at least dp[j] items.
2. Determine the Recurrence Relation (State Transition Equation)
 `dp[j] = Math.min(dp[j-coins[i]], dp[j])`
3. Initialize the dp Array
   dp[0] = 0, others are set to the max integer.
4. Determine the Traversal Order
   Both are ok.

```Java
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
```























