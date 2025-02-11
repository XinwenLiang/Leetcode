# 代码随想录算法训练营第二天
## [209.Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)

Given an array of positive integers `nums` and a positive integer `target`, return the **minimal length** of a <br>
subarray whose sum is greater than or equal to `target`. If there is no such subarray, return `0` instead.

**Idea**: A brute force solution can be used by employing two `for` loops to represent the start and end of the interval, respectively.<br>
An optimized approach utilizes the `sliding window` technique, which is essentially similar to the `two-pointer` method discussed yesterday, <br>
but here we consider the portion between the `two pointers`.We can continuously adjust the starting and ending positions until we find the subarray
with the minimum length that satisfies the condition. Using a `for` loop to represent the `sliding window`, if we choose the starting point as the loop 
variable, we would still fall into the brute force approach. Therefore, we should select the endpoint as the loop variable.

```Java
// Brute force method
public class minSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE; //Initialize the maximum value of type int.
        int sum = 0;
        int subLength = 0;
        for (int i = 0; i < nums.length; i++) { //Set the starting point of the subsequence to be i.
            sum = 0;
            for (int j = i; j < nums.length; j++) {//Set the end point of the subsequence to be j.
                sum += nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    result = Math.min(result, subLength);
                    break; //Once meet the condition, break the loop.
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

// Sliding window method
public class minSubArrLen {
    public static int minSubArrLen(int target, int[] nums) {
        int left = 0; // Starting point.
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) { // The end point.
            sum += nums[i];
            while (sum >= target) {
                result = Math.min(result, i - left + 1);
                sum -= nums[left];//Removes the elements on the left border of the window from the sum in an attempt to shrink the window
                left++;
            }
        }
        return result != Integer.MAX_VALUE ? result : 0;
    }
}
```

## [59.Spiral Matrix](https://leetcode.com/problems/spiral-matrix-ii/)

Given a positive integer `n`, generate an **n x n matrix** filled with elements from 1 to n2 in **spiral order**.

 **Idea**: You can refer to the diagram below. Since directly analyzing n elements can be complex, we take `n = 3` as an example to understand how the loop works.<br>
 By observing the pattern, it is easy to find that the number of layers in the matrix is `int(n / 2)`, where the result is rounded down. 
 Then, we iterate through the four sides of each layer.

(Drawing a diagram makes the entire idea much clearer. I strongly recommend you to draw one for better understanding at a glance.)

  <p align="center">
  <img src="https://github.com/user-attachments/assets/746ea714-ce51-43c6-851d-d7279f371da2" alt="图片3" width="800">
</p>

```Java
public class SpiralMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0;
        int startY = 0; //Set the start point as (0,0)
        int offset = 1; // Set the variable to control the end position.
        int count = 1; // The element in the matrix.

        while (startX <= n / 2) {
            for (int j = startY; j < n - offset; j++) {
                nums[startX][j] = count;
                count++;
            }

            for (int i = startX; i < n - offset; i++) {
                nums[i][n - offset] = count;
                count++;
            }

            for (int j = n - offset; j > startY; j--) {
                nums[n - offset][j] = count;
                count++;
            }

            for (int i = n - offset; i > startX; i--) {
                nums[i][startY] = count;
                count++;
            }
            startY++;
            startX++;
            offset++;
            if (n % 2 != 0) {
                nums[n / 2][n / 2] = n * n;
            }
        }
        return nums;
    }
}
```

## [58.Interval Sum](https://kamacoder.com/problempage.php?pid=1070)

Given an integer array Array, calculate the sum of elements within the specified intervals.
**Input**: The first line of input provides the length of the integer array, n.
The next n lines each contain a single integer, representing the elements of the array.
The following input contains the intervals for which the sum of elements needs to be calculated, continuing until the end of the file.
**Output**: Output the sum of elements for each specified interval.

**Idea**: We can use **prefix sum** concept to solve the problem, the process is as followed.

<p align="center">
  <img src="https://github.com/user-attachments/assets/da3ac810-be92-4e38-a7e6-bd70bfd992f1" alt="图片3" width="600">
</p>

```Java
public class RangeSum {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int[] vec = new int[n];
        int[] p = new int[n];
        int preSum = 0;
        
        // Read the array elements and calculate the prefix sum
        for (int i = 0; i < n; i++) {
            vec[i] = myScanner.nextInt();
            preSum += vec[i];
            p[i] = preSum;
        }
        // Get the interval through input.
        while (myScanner.hasNextInt()){
            int a = myScanner.nextInt();
            int b = myScanner.nextInt();

            int sum;
            if(a==0){
                sum = p[b];
            }else{
                sum = p[b] - p[a-1];
            }
            System.out.println(sum);
        }
        myScanner.close();
    }
}
```
## [44.Purchase of land by developers](https://kamacoder.com/problempage.php?pid=1044)

**Problem Description**<br>

In a city's region, it is divided into `n * m` contiguous blocks, each with a different weight representing the land value of that block. Currently, two companies, Company A and Company B, want to purchase the land in this city's region.<br>

Now, you need to divide all blocks in the city's region into two sub-regions, assigned to Company A and Company B, respectively. However, due to city planning restrictions, the region can only be divided horizontally or vertically into two sub-regions. Each sub-region must contain one or more blocks, and blocks cannot be further subdivided.<br>

To ensure fairness, you need to find a way to divide the region such that the absolute difference between the total land value of the blocks in Company A's sub-region and Company B's sub-region is minimized.

**Interpretation**

The objective of this problem is to divide an `n × m` rectangular area into two sub-areas to be allocated to firms A and B, and to ensure that the **difference** in the total value of land in the areas allocated to the two firms is **minimised**.

Restrictions on the way it can be divided: A rectangle can only be divided into two consecutive sub-areas by a single line: horizontal or vertical.

  **Idea**:
* Brute Force Approach:

Horizontal Division: Try splitting the region below each row, calculating the total value of the top and bottom parts.<br> 
Vertical Division: Try splitting the region to the right of each column, calculating the total value of the left and right parts.<br>
For all possible division methods, calculate the difference in total values of the two parts and find the smallest difference.

* Optimized Approach (Using Prefix Sum):

Precompute the prefix sums for each row and each column to quickly calculate the total value of any region.
Use the prefix sum to reduce redundant calculations and improve efficiency.

```Java
// Optimized brute force method.
public class LandPurchase {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();
        int sum = 0;
        int[][] vec = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vec[i][j] = myScanner.nextInt();
                sum += vec[i][j]; // Calculate the total value of the land.
            }
        }
        int result = Integer.MAX_VALUE;
        int count = 0;//Used to store the cumulative sum of traversed areas.

        // Horizontal division.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += vec[i][j];
                // Update the minimum difference when traversing to the end of the row.
                if(j==m-1){
                    result = Math.min(result, Math.abs(sum-2*count));
                }
            }
        }

        // Vertical division.
        count = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                count += vec[i][j];
                // Update the minimum difference when traversing to the end of the column.
                if(i==n-1){
                    result = Math.min(result, Math.abs(sum-2*count));
                }
            }
        }
        System.out.println(result);
        myScanner.close();
    }
}

// Prefix sum method
public class LandPurchase2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();
        int[][] vec = new int[n][m];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vec[i][j] = myScanner.nextInt();
                sum += vec[i][j]; // Calculate the total value of the land.
            }
        }
        // Calculate the horizontal sum
        int[] horizontal = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                horizontal[i] += vec[i][j];
            }
        }

        // Calculate the vertical sum
        int[] vertical = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                vertical[j] += vec[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        int horizontalCut = 0;
        for (int i = 0; i < n; i++) {
            horizontalCut += horizontal[i];
            result = Math.min(result, Math.abs(sum - 2 * horizontalCut));
        }

        int verticalCut = 0;
        for (int j = 0; j < m; j++) {
            verticalCut += vertical[j];
            result = Math.min(result, Math.abs(sum - 2 * verticalCut));
        }

        System.out.println(result);
        myScanner.close();
    }
}
```





## In all the shabby fading, please shine forever.

<p align="center">
  <img src="https://github.com/user-attachments/assets/419dae10-6ef0-4dd4-9c4c-c0917d723b94" alt="图片3" width="600">
</p>

