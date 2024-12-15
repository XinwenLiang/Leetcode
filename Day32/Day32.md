# 代码随想录算法训练营第三十二天
## [509. Fibonacci Number](https://leetcode.com/problems/fibonacci-number/description/)

The **Fibonacci numbers**, commonly denoted `F(n)` form a sequence, called the **Fibonacci sequence**, such that each number is the sum of the two preceding ones, starting from `0` and `1`. That is,

F(0) = 0, F(1) = 1 <br>
F(n) = F(n - 1) + F(n - 2), for n > 1. <br>
Given `n`, calculate `F(n)`.

**Example 1:**

**Input:** n = 2 <br>
**Output:** 1 <br>
**Explanation:** F(2) = F(1) + F(0) = 1 + 0 = 1.

**Ideas:** 
This problem can be solved using recursion, but to practice dynamic programming, we will solve it following the five-step dynamic programming approach. Here, we will use a one-dimensional dp array to store the results 
of the recursive calculations.

1. Define the dp Array and Its Index Meaning
  The definition of `dp[i]` is: the Fibonacci value of the `i-th` number is stored in `dp[i]`.
2. Determine the Recurrence Relation (State Transition Equation)
   The state transition equation is: dp[i] = dp[i-1] + dp[i-2]
3. Initialize the dp Array
   dp[0] = 0, dp[1] = 1
4. Determine the Traversal Order
   From the recurrence relation dp[i] = dp[i-1] + dp[i-2], it is clear that dp[i] depends on dp[i-1] and dp[i-2]. Therefore, the traversal order must be from front to back (i.e., increasing order of i.)
5. Derive the dp Array with an Example
   Using the recurrence formula dp[i] = dp[i-1] + dp[i-2], let us derive the dp array when 𝑁 = 10. The dp array should look like this:[0,1,1,2,3,5,8,13,21,34,55]

```Java
public class FibonacciNumber {
    public int fib(int n){
        if(n <= 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
```

## [70. Climb Stairs](https://leetcode.com/problems/climbing-stairs/description/)

You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?

**Example 1:**

**Input:** n = 2 <br>
**Output:** 2<br>
**Explanation:** There are two ways to climb to the top. <br>
1. 1 step + 1 step
2. 2 steps

**Ideas:**
1. Define the dp Array and Its Index Meaning
  The definition of `dp[i]` is: There are dp[i] methods to reach the top.
2. Determine the Recurrence Relation (State Transition Equation)
   The state transition equation is: dp[i] = dp[i-1] + dp[i-2]
3. Initialize the dp Array
   dp[0] = 1, dp[1] = 1, dp[2] = 2
4. Determine the Traversal Order
   From the recurrence relation dp[i] = dp[i-1] + dp[i-2], it is clear that dp[i] depends on dp[i-1] and dp[i-2]. Therefore, the traversal order must be from front to back (i.e., increasing order of i.)
5. Derive the dp Array with an Example
   Using the recurrence formula dp[i] = dp[i-1] + dp[i-2], let us derive the dp array when 𝑁 = 10. The dp array should look like this:[1,1,2,3,5,8,13,21,34,55,89]

```Java
public class ClimbStairs {
    public int climbStairs(int n){
        int[] dp = new int[n +2];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
```






















