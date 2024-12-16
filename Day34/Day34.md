# 代码随想录算法训练营第三十四天
## [62. Unique Paths](https://leetcode.com/problems/unique-paths/description/)

There is a robot on an `m x n` grid. The robot is initially located at the **top-left corner** (i.e., `grid[0][0]`). The robot tries to move to the **bottom-right corner** (i.e., `grid[m - 1][n - 1]`). The robot can 
only move either down or right at any point in time.

Given the two integers `m` and `n`, return *the number of possible unique paths that the robot can take to reach the bottom-right corner*.

The test cases are generated so that the answer will be less than or equal to `2 * 109`.

**Example**


![image](https://github.com/user-attachments/assets/b2c1ff3f-0426-46cc-bf0a-7d7a10e4e49a)

**Input:** m = 3, n = 7 <br>
**Output:** 28

**Ideas:**
1. Define the dp Array and Its Index Meaning
  The definition of `dp[i][j]` is: Walking from [0,0] to [i,j] has dp[i][j] methods.
2. Determine the Recurrence Relation (State Transition Equation)
   The state transition equation is: dp[i][j] = dp[i-1][j] + dp[i][j-1]
3. Initialize the dp Array
   The initialization should be such that moving either horizontally or vertically to any point is considered as one way.
   ```Java
   for (int i = 0; i < m; i++){
     dp[i][0] = 1;
   }
   for (int j = 0; j < n; j++){
      dp[0][j] = 1;
   }
   ```
4. Determine the Traversal Order
   From front to back.

```Java
public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i<m;i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j <n; j++){
            dp[0][j] = 1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
```

## [Unique Paths II](https://leetcode.com/problems/unique-paths-ii/description/)

You are given an `m x n` integer array `grid`. There is a robot initially located at the **top-left corner** (i.e., `grid[0][0]`). The robot tries to move to the **bottom-right corner** (i.e., `grid[m - 1][n - 1]`). 
The robot can only move either down or right at any point in time.

An obstacle and space are marked as `1` or `0` respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return *the number of possible unique paths that the robot can take to reach the bottom-right corner*.

The testcases are generated so that the answer will be less than or equal to `2 * 109`.

**Example1:**


![image](https://github.com/user-attachments/assets/f5be06fc-8fe9-4004-ac31-e11b95ee62a6)

**Input:** obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] <br>
**Output:** 2 <br>
**Explanation:** There is one obstacle in the middle of the 3x3 grid above. <br>
There are two ways to reach the bottom-right corner:<br>
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

1. Define the dp Array and Its Index Meaning
  The definition of `dp[i][j]` is: Walking from [0,0] to [i,j] has dp[i][j] methods. `obs[i][j] = 1` means there exists an obstacle at [i,j].
2. Determine the Recurrence Relation (State Transition Equation)
   The state transition equation is: dp[i][j] = dp[i-1][j] + dp[i][j-1], but we have to add a condition`if obs[i][j] == 0`
3. Initialize the dp Array
   The initialization should be such that moving either horizontally or vertically to any point is considered as one way.
   ```Java
   for (int i = 0; i < m && obs[i][0] == 0; i++){
     dp[i][0] = 1;
   }
   for (int j = 0; j < n && obs[0][j] == 0; j++){
      dp[0][j] = 1;
   }
   ```
4. Determine the Traversal Order
   From front to back.

```Java
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        // Initialization.
        for (int i = 0; i < m && obstacleGrid[i][0]==0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
```






























